import java.math.BigDecimal;

/**
 * This code was migrated from C# and hence will be shared back to the C# owner.
 * This code is shared to the net.
 * 
 * @author Michael.Toledo
 *
 */
public class NumberToArabic {
	private static BigDecimal number;
	private static Currency currency;
	private static CurrencyInfo currencyInfo;	
	
	private static String englishPrefixText = "";
	private static String englishSuffixText = "only.";
	private static String arabicPrefixText = "فقط";
	private static String arabicSuffixText = "لا غير.";
	
	private static long _intergerValue;
	private static int _decimalValue;
	
	/**
	 * BHD - not implemented
	 * JOD - not implemented
	 */
	public static enum Currency {
		AED, SYP, SAR, TND, XAU, JOD, BHD
	}
	
	private static String[] englishOnes =
        new String[] {
         "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
         "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

	private static String[] englishTens =
	     new String[] {
	     "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
	};
	
	private static String[] englishGroup =
	     new String[] {
	     "Hundred", "Thousand", "Million", "Billion", "Trillion", "Quadrillion", "Quintillion", "Sextillian",
	     "Septillion", "Octillion", "Nonillion", "Decillion", "Undecillion", "Duodecillion", "Tredecillion",
	     "Quattuordecillion", "Quindecillion", "Sexdecillion", "Septendecillion", "Octodecillion", "Novemdecillion",
	     "Vigintillion", "Unvigintillion", "Duovigintillion", "10^72", "10^75", "10^78", "10^81", "10^84", "10^87",
	     "Vigintinonillion", "10^93", "10^96", "Duotrigintillion", "Trestrigintillion"
	};
	
	private static String[] arabicOnes =
        new String[] {
         "", "واحد", "اثنان", "ثلاثة", "أربعة", "خمسة", "ستة", "سبعة", "ثمانية", "تسعة",
         "عشرة", "أحد عشر", "اثنا عشر", "ثلاثة عشر", "أربعة عشر", "خمسة عشر", "ستة عشر", "سبعة عشر", "ثمانية عشر", "تسعة عشر"
     };

     private static String[] arabicFeminineOnes =
        new String[] {
         "", "إحدى", "اثنتان", "ثلاث", "أربع", "خمس", "ست", "سبع", "ثمان", "تسع",
         "عشر", "إحدى عشرة", "اثنتا عشرة", "ثلاث عشرة", "أربع عشرة", "خمس عشرة", "ست عشرة", "سبع عشرة", "ثماني عشرة", "تسع عشرة"
     };

     private static String[] arabicTens =
         new String[] {
         "عشرون", "ثلاثون", "أربعون", "خمسون", "ستون", "سبعون", "ثمانون", "تسعون"
     };

     private static String[] arabicHundreds =
         new String[] {
         "", "مائة", "مئتان", "ثلاثمائة", "أربعمائة", "خمسمائة", "ستمائة", "سبعمائة", "ثمانمائة","تسعمائة"
     };

     private static String[] arabicAppendedTwos =
         new String[] {
         "مئتا", "ألفا", "مليونا", "مليارا", "تريليونا", "كوادريليونا", "كوينتليونا", "سكستيليونا"
     };

     private static String[] arabicTwos =
         new String[] {
         "مئتان", "ألفان", "مليونان", "ملياران", "تريليونان", "كوادريليونان", "كوينتليونان", "سكستيليونان"
     };

     private static String[] arabicGroup =
         new String[] {
         "مائة", "ألف", "مليون", "مليار", "تريليون", "كوادريليون", "كوينتليون", "سكستيليون"
     };

     private static String[] arabicAppendedGroup =
         new String[] {
         "", "ألفاً", "مليوناً", "ملياراً", "تريليوناً", "كوادريليوناً", "كوينتليوناً", "سكستيليوناً"
     };

     private static String[] arabicPluralGroups =
         new String[] {
         "", "آلاف", "ملايين", "مليارات", "تريليونات", "كوادريليونات", "كوينتليونات", "سكستيليونات"
     };
	
    public NumberToArabic() {	
    	 
    }
     
	public NumberToArabic(BigDecimal number, Currency currency) {	
		NumberToArabic.number = number;		
		NumberToArabic.currency = currency;
		NumberToArabic.currencyInfo = new CurrencyInfo(currency);
		
		numberToArabic(number, currencyInfo, englishPrefixText, englishSuffixText, arabicPrefixText, arabicSuffixText);
	}
	
	public NumberToArabic(BigDecimal number, Currency currency, String englishPrefixText, String englishSuffixText, String arabicPrefixText, String arabicSuffixText) {
		NumberToArabic.number = number;
		NumberToArabic.currency = currency;
		NumberToArabic.currencyInfo = new CurrencyInfo(currency);
		
		numberToArabic(number, currencyInfo, englishPrefixText, englishSuffixText, arabicPrefixText, arabicSuffixText);
	}
	
	private static void numberToArabic(BigDecimal number, CurrencyInfo currency, String englishPrefixText, String englishSuffixText, String arabicPrefixText, String arabicSuffixText) {		
        NumberToArabic.englishPrefixText = englishPrefixText;
        NumberToArabic.englishSuffixText = englishSuffixText;
        NumberToArabic.arabicPrefixText = arabicPrefixText;
        NumberToArabic.arabicSuffixText = arabicSuffixText;

        extractIntegerAndDecimalParts();
	}
	
	private static void extractIntegerAndDecimalParts() {		
        String[] splits = number.toString().split("\\.");

        _intergerValue = Long.valueOf(splits[0]).longValue();

        if (splits.length > 1)
            _decimalValue = Integer.valueOf(getDecimalValue(splits[1]));
        else 
        	_decimalValue = 0;
    }
	
	private static String getDecimalValue(String decimalPart) {
		String result = "";

        if (currencyInfo.getPartPrecision() != decimalPart.length()) {
                int decimalPartLength = decimalPart.Length;

                for (int i = 0; i < Currency.PartPrecision - decimalPartLength; i++)
                {
                    decimalPart += "0"; //Fix for 1 number after decimal ( 10.5 , 1442.2 , 375.4 ) 
                }

				int dec = decimalPart.length() <= currencyInfo.getPartPrecision()  ?  decimalPart.length() : currencyInfo.getPartPrecision();  
            result = decimalPart.substring(0, dec);
        }
        else
            result = decimalPart;

        for (int i = result.length(); i < currencyInfo.getPartPrecision(); i++) {
            result += "0";
        }

        return result;
    }
	
    private static String processGroup(int groupNumber) {
        int tens = groupNumber % 100;

        int hundreds = groupNumber / 100;

        String retVal = "";

        if (hundreds > 0) {
            retVal = String.format("%s %s", englishOnes[hundreds], englishGroup[0]);
        }
        if (tens > 0) {
            if (tens < 20) {
                retVal += ((retVal != "") ? " " : "") + englishOnes[tens];
            }
            else {
                int ones = tens % 10;

                tens = (tens / 10) - 2; // 20's offset

                retVal += ((retVal != "") ? " " : "") + englishTens[tens];

                if (ones > 0) {
                    retVal += ((retVal != "") ? " " : "") + englishOnes[ones];
                }
            }
        }

        return retVal;
    }	
    
    public static String convertToEnglish(BigDecimal value, String currencyCode) {    	   	
    	currency = Currency.valueOf(currencyCode);
    	currencyInfo = (new NumberToArabic()).new CurrencyInfo(currency);
    	number = value.setScale(currencyInfo.getPartPrecision(), BigDecimal.ROUND_HALF_DOWN);
    	
    	numberToArabic(number, currencyInfo, englishPrefixText, englishSuffixText, arabicPrefixText, arabicSuffixText);
    	
		return convertToEnglish();
    }
	
    public static String convertToEnglish() {
        BigDecimal tempNumber = number;

        if (tempNumber.compareTo(new BigDecimal(0)) == 0)
            return "Zero";

        String decimalString = processGroup(_decimalValue);

        String retVal = "";

        int group = 0;

        if (tempNumber.compareTo(new BigDecimal(0)) < 1)  {
            retVal = englishOnes[0];
        }
        else {
            while (tempNumber.compareTo(new BigDecimal(0)) > 0) {
                int numberToProcess = tempNumber.remainder(new BigDecimal(1000)).intValue();

                tempNumber = tempNumber.divideToIntegralValue(new BigDecimal(1000));

                String groupDescription = processGroup(numberToProcess);

                if (groupDescription != "") {
                    if (group > 0) {
                        retVal = String.format("%s %s", englishGroup[group], retVal);
                    }

                    retVal = String.format("%s %s", groupDescription, retVal);
                }

                group++;
            }
        }

        String formattedNumber = "";
        formattedNumber += (englishPrefixText != "") ? String.format("%s ", englishPrefixText) : "";
        formattedNumber += (retVal != "") ? retVal : "";
        formattedNumber += (retVal != "") ? (_intergerValue == 1 ? currencyInfo.englishCurrencyName : currencyInfo.englishPluralCurrencyName) : "";
        formattedNumber += (decimalString != "") ? " and " : "";
        formattedNumber += (decimalString != "") ? decimalString : "";
        formattedNumber += (decimalString != "") ? " " + (_decimalValue == 1 ? currencyInfo.englishCurrencyPartName : currencyInfo.englishPluralCurrencyPartName) : "";
        formattedNumber += (englishSuffixText != "") ? String.format(" %s", englishSuffixText) : "";

        return formattedNumber;
    }
    
    private static String getDigitFeminineStatus(int digit, int groupLevel) {
        if (groupLevel == -1) { // if it is in the decimal part
            if (currencyInfo.isCurrencyPartNameFeminine)
                return arabicFeminineOnes[digit]; // use feminine field
            else
                return arabicOnes[digit];
        }
        else
            if (groupLevel == 0) {
                if (currencyInfo.isCurrencyNameFeminine)
                    return arabicFeminineOnes[digit];// use feminine field
                else
                    return arabicOnes[digit];
            }
            else
                return arabicOnes[digit];
    }
    
    private static String processArabicGroup(int groupNumber, int groupLevel, BigDecimal remainingNumber) {
        int tens = groupNumber % 100;

        int hundreds = groupNumber / 100;

        String retVal = "";

        if (hundreds > 0) {
            if (tens == 0 && hundreds == 2) // حالة المضاف
                retVal = String.format("%s", arabicAppendedTwos[0]);
            else //  الحالة العادية
                retVal = String.format("%s", arabicHundreds[hundreds]);
        }

        if (tens > 0) {
            if (tens < 20) { // if we are processing under 20 numbers
                if (tens == 2 && hundreds == 0 && groupLevel > 0) { // This is special case for number 2 when it comes alone in the group
                    if (_intergerValue == 2000 || _intergerValue == 2000000 || _intergerValue == 2000000000 || _intergerValue == 2000000000000L || _intergerValue == 2000000000000000L || _intergerValue == 2000000000000000000L)
                        retVal = String.format("%s", arabicAppendedTwos[groupLevel]); // في حالة الاضافة
                    else
                        retVal = String.format("%s", arabicTwos[groupLevel]);//  في حالة الافراد
                }
                else { // General case
                    if (retVal != "")
                        retVal += " و ";

                    if (tens == 1 && groupLevel > 0 && hundreds == 0)
                        retVal += " ";
                    else
                        if ((tens == 1 || tens == 2) && (groupLevel == 0 || groupLevel == -1) && hundreds == 0 && remainingNumber.compareTo(new BigDecimal(0)) == 0)
                            retVal += ""; // Special case for 1 and 2 numbers like: ليرة سورية و ليرتان سوريتان
                        else
                            retVal += getDigitFeminineStatus(tens, groupLevel);// Get Feminine status for this digit
                }
            }
            else {
                int ones = tens % 10;
                tens = (tens / 10) - 2; // 20's offset

                if (ones > 0) {
                    if (retVal != "")
                        retVal += " و ";

                    // Get Feminine status for this digit
                    retVal += getDigitFeminineStatus(ones, groupLevel);
                }

                if (retVal != "")
                    retVal += " و ";

                // Get Tens text
                retVal += arabicTens[tens];
            }
        }

        return retVal;
    }
    
    
    public static String convertToArabic(BigDecimal value, String currencyCode) {
    	currency = Currency.valueOf(currencyCode);
    	currencyInfo = (new NumberToArabic()).new CurrencyInfo(currency);
    	number = value.setScale(currencyInfo.getPartPrecision(), BigDecimal.ROUND_HALF_DOWN);
    	
    	numberToArabic(number, currencyInfo, englishPrefixText, englishSuffixText, arabicPrefixText, arabicSuffixText);
    	
		return convertToArabic();
    }
    
    public static String convertToArabic()
    {
        BigDecimal tempNumber = number;

        if (tempNumber.compareTo(new BigDecimal(0)) == 0)
            return "صفر";

        // Get Text for the decimal part
        String decimalString = processArabicGroup(_decimalValue, -1, new BigDecimal(0));

        String retVal = ""; 
        Byte group = 0;
        while (tempNumber.compareTo(new BigDecimal(0)) > 0)
        {
            // seperate number into groups
            int numberToProcess = tempNumber.remainder(new BigDecimal(1000)).intValue();

            tempNumber = tempNumber.divideToIntegralValue(new BigDecimal(1000));

            // convert group into its text
            String groupDescription = processArabicGroup(numberToProcess, group, new BigDecimal(Math.floor(tempNumber.doubleValue())));

            if (groupDescription != "")
            { // here we add the new converted group to the previous concatenated text
                if (group > 0)
                {
                    if (retVal != "")
                        retVal = String.format("%s %s", "و", retVal);

                    if (numberToProcess != 2)
                    {
                        if (numberToProcess % 100 != 1)
                        {
                            if (numberToProcess >= 3 && numberToProcess <= 10) // for numbers between 3 and 9 we use plural name
                                retVal = String.format("%s %s", arabicPluralGroups[group], retVal);
                            else
                            {
                                if (retVal != "") // use appending case
                                    retVal = String.format("%s %s", arabicAppendedGroup[group], retVal);
                                else
                                    retVal = String.format("%s %s", arabicGroup[group], retVal); // use normal case
                            }
                        }
						else
							retVal = String.format("%s %s", arabicGroup[group], retVal); // use normal case
                    }
                }

                retVal = String.format("%s %s", groupDescription, retVal);
            }

            group++;
        }

        String formattedNumber = "";
        formattedNumber += (arabicPrefixText != "") ? String.format("%s ", arabicPrefixText) : "";
        formattedNumber += (retVal != "") ? retVal : "";
        if (_intergerValue != 0)
        { // here we add currency name depending on _intergerValue : 1 ,2 , 3--->10 , 11--->99
            int remaining100 = (int)(_intergerValue % 100);

            if (remaining100 == 0)
                formattedNumber += currencyInfo.arabic1CurrencyName;
            else
                if (remaining100 == 1)
                    formattedNumber += currencyInfo.arabic1CurrencyName;
                else
                    if (remaining100 == 2)
                    {
                        if (_intergerValue == 2)
                            formattedNumber += currencyInfo.arabic2CurrencyName;
                        else
                            formattedNumber += currencyInfo.arabic1CurrencyName;
                    }
                    else
                        if (remaining100 >= 3 && remaining100 <= 10)
                            formattedNumber += currencyInfo.arabic310CurrencyName;
                        else
                            if (remaining100 >= 11 && remaining100 <= 99)
                                formattedNumber += currencyInfo.arabic1199CurrencyName;
        }
        formattedNumber += (_decimalValue != 0) ? " و " : "";
        formattedNumber += (_decimalValue != 0) ? decimalString : "";
        if (_decimalValue != 0)
        { // here we add currency part name depending on _intergerValue : 1 ,2 , 3--->10 , 11--->99
            formattedNumber += " ";

            int remaining100 = (int)(_decimalValue % 100);

            if (remaining100 == 0)
                formattedNumber += currencyInfo.arabic1CurrencyPartName;
            else
                if (remaining100 == 1)
                    formattedNumber += currencyInfo.arabic1CurrencyPartName;
                else
                    if (remaining100 == 2)
                        formattedNumber += currencyInfo.arabic2CurrencyPartName;
                    else
                        if (remaining100 >= 3 && remaining100 <= 10)
                            formattedNumber += currencyInfo.arabic310CurrencyPartName;
                        else
                            if (remaining100 >= 11 && remaining100 <= 99)
                                formattedNumber += currencyInfo.arabic1199CurrencyPartName;
        }
        formattedNumber += (arabicSuffixText != "") ? String.format(" %s", arabicSuffixText) : "";

        return formattedNumber;
    }
    
    
    
	class CurrencyInfo {
		Currency currencyID;
		String currencyCode;
        boolean isCurrencyNameFeminine;
        String englishCurrencyName;
        String englishPluralCurrencyName;
        String englishCurrencyPartName;
        String englishPluralCurrencyPartName;
        String arabic1CurrencyName;
        String arabic2CurrencyName;
        String arabic310CurrencyName;
        String arabic1199CurrencyName;
        String arabic1CurrencyPartName;
        String arabic2CurrencyPartName;
        String arabic310CurrencyPartName;
        String arabic1199CurrencyPartName;
        int partPrecision;
        boolean isCurrencyPartNameFeminine;
		
        public Currency getCurrencyID() {
			return currencyID;
		}

		public void setCurrencyID(Currency currencyID) {
			this.currencyID = currencyID;
		}

		public String getCurrencyCode() {
			return currencyCode;
		}

		public void setCurrencyCode(String currencyCode) {
			this.currencyCode = currencyCode;
		}

		public boolean isCurrencyNameFeminine() {
			return isCurrencyNameFeminine;
		}

		public void setCurrencyNameFeminine(boolean isCurrencyNameFeminine) {
			this.isCurrencyNameFeminine = isCurrencyNameFeminine;
		}

		public String getEnglishCurrencyName() {
			return englishCurrencyName;
		}

		public void setEnglishCurrencyName(String englishCurrencyName) {
			this.englishCurrencyName = englishCurrencyName;
		}

		public String getEnglishPluralCurrencyName() {
			return englishPluralCurrencyName;
		}

		public void setEnglishPluralCurrencyName(String englishPluralCurrencyName) {
			this.englishPluralCurrencyName = englishPluralCurrencyName;
		}

		public String getEnglishCurrencyPartName() {
			return englishCurrencyPartName;
		}

		public void setEnglishCurrencyPartName(String englishCurrencyPartName) {
			this.englishCurrencyPartName = englishCurrencyPartName;
		}

		public String getEnglishPluralCurrencyPartName() {
			return englishPluralCurrencyPartName;
		}

		public void setEnglishPluralCurrencyPartName(
				String englishPluralCurrencyPartName) {
			this.englishPluralCurrencyPartName = englishPluralCurrencyPartName;
		}

		public String getArabic1CurrencyName() {
			return arabic1CurrencyName;
		}

		public void setArabic1CurrencyName(String arabic1CurrencyName) {
			this.arabic1CurrencyName = arabic1CurrencyName;
		}

		public String getArabic2CurrencyName() {
			return arabic2CurrencyName;
		}

		public void setArabic2CurrencyName(String arabic2CurrencyName) {
			this.arabic2CurrencyName = arabic2CurrencyName;
		}

		public String getArabic310CurrencyName() {
			return arabic310CurrencyName;
		}

		public void setArabic310CurrencyName(String arabic310CurrencyName) {
			this.arabic310CurrencyName = arabic310CurrencyName;
		}

		public String getArabic1199CurrencyName() {
			return arabic1199CurrencyName;
		}

		public void setArabic1199CurrencyName(String arabic1199CurrencyName) {
			this.arabic1199CurrencyName = arabic1199CurrencyName;
		}

		public String getArabic1CurrencyPartName() {
			return arabic1CurrencyPartName;
		}

		public void setArabic1CurrencyPartName(String arabic1CurrencyPartName) {
			this.arabic1CurrencyPartName = arabic1CurrencyPartName;
		}

		public String getArabic2CurrencyPartName() {
			return arabic2CurrencyPartName;
		}

		public void setArabic2CurrencyPartName(String arabic2CurrencyPartName) {
			this.arabic2CurrencyPartName = arabic2CurrencyPartName;
		}

		public String getArabic310CurrencyPartName() {
			return arabic310CurrencyPartName;
		}

		public void setArabic310CurrencyPartName(String arabic310CurrencyPartName) {
			this.arabic310CurrencyPartName = arabic310CurrencyPartName;
		}

		public String getArabic1199CurrencyPartName() {
			return arabic1199CurrencyPartName;
		}

		public void setArabic1199CurrencyPartName(String arabic1199CurrencyPartName) {
			this.arabic1199CurrencyPartName = arabic1199CurrencyPartName;
		}

		public int getPartPrecision() {
			return partPrecision;
		}

		public void setPartPrecision(int partPrecision) {
			this.partPrecision = partPrecision;
		}

		public boolean isCurrencyPartNameFeminine() {
			return isCurrencyPartNameFeminine;
		}

		public void setCurrencyPartNameFeminine(boolean isCurrencyPartNameFeminine) {
			this.isCurrencyPartNameFeminine = isCurrencyPartNameFeminine;
		}
		
		public CurrencyInfo(Currency currency) {
			switch (currency) {
				case AED : 	currencyID = currency;
                			currencyCode = currency.toString();
                			isCurrencyNameFeminine = false;
                			englishCurrencyName = "UAE Dirham";
                			englishPluralCurrencyName = "UAE Dirhams";
                			englishCurrencyPartName = "Fils";
                			englishPluralCurrencyPartName = "Fils";
                			arabic1CurrencyName = "درهم إماراتي";
                			arabic2CurrencyName = "درهمان إماراتيان";
                			arabic310CurrencyName = "دراهم إماراتية";
                			arabic1199CurrencyName = "درهماً إماراتياً";
                			arabic1CurrencyPartName = "فلس";
                			arabic2CurrencyPartName = "فلسان";
                			arabic310CurrencyPartName = "فلوس";
                			arabic1199CurrencyPartName = "فلساً";
                			partPrecision = 2;
                			isCurrencyPartNameFeminine = false;					
					break;
				case JOD :  currencyID = currency;
    						currencyCode = currency.toString();
    						isCurrencyNameFeminine = false;
    						englishCurrencyName = "Jordanian Dinar";
    						englishPluralCurrencyName = "Jordanian Dinars";
    						englishCurrencyPartName = "Fils";
    						englishPluralCurrencyPartName = "Fils";
    						arabic1CurrencyName = "دينار أردني";
    						arabic2CurrencyName = "ديناران أردنيان";
    						arabic310CurrencyName = "دنانير أردنية";
    						arabic1199CurrencyName = "ديناراً أردنياً";
    						arabic1CurrencyPartName = "فلس";
    						arabic2CurrencyPartName = "فلسان";
    						arabic310CurrencyPartName = "فلوس";
    						arabic1199CurrencyPartName = "فلساً";
    						partPrecision = 3;
    						isCurrencyPartNameFeminine = false;
    				break;
				case BHD : 	currencyID = currency;
							currencyCode = currency.toString();
							isCurrencyNameFeminine = false;
							englishCurrencyName = "Bahraini Dinar";
							englishPluralCurrencyName = "Bahraini Dinars";
							englishCurrencyPartName = "Fils";
							englishPluralCurrencyPartName = "Fils";
							arabic1CurrencyName = "دينار بحريني";
							arabic2CurrencyName = "ديناران بحرينيان";
							arabic310CurrencyName = "دنانير بحرينية";
							arabic1199CurrencyName = "ديناراً بحرينياً";
							arabic1CurrencyPartName = "فلس";
							arabic2CurrencyPartName = "فلسان";
							arabic310CurrencyPartName = "فلوس";
							arabic1199CurrencyPartName = "فلساً";
							partPrecision = 3;
							isCurrencyPartNameFeminine = false;
					break;
				case SAR :  currencyID = currency;
                			currencyCode = currency.toString();	
                			isCurrencyNameFeminine = false;
                			englishCurrencyName = "Saudi Riyal";
                			englishPluralCurrencyName = "Saudi Riyals";
                			englishCurrencyPartName = "Halala";
                			englishPluralCurrencyPartName = "Halalas";
                			arabic1CurrencyName = "ريال سعودي";
                			arabic2CurrencyName = "ريالان سعوديان";
                			arabic310CurrencyName = "ريالات سعودية";
                			arabic1199CurrencyName = "ريالاً سعودياً";
                			arabic1CurrencyPartName = "هللة";
                			arabic2CurrencyPartName = "هللتان";
                			arabic310CurrencyPartName = "هللات";
                			arabic1199CurrencyPartName = "هللة";
                			partPrecision = 2;
                			isCurrencyPartNameFeminine = true;
					break;
				case SYP : 	currencyID = currency;
                			currencyCode = currency.toString();
                			isCurrencyNameFeminine = true;
                			englishCurrencyName = "Syrian Pound";
                			englishPluralCurrencyName = "Syrian Pounds";
                			englishCurrencyPartName = "Piaster";
                			englishPluralCurrencyPartName = "Piasteres";
                			arabic1CurrencyName = "ليرة سورية";
                			arabic2CurrencyName = "ليرتان سوريتان";
                			arabic310CurrencyName = "ليرات سورية";
                			arabic1199CurrencyName = "ليرة سورية";
                			arabic1CurrencyPartName = "قرش";
                			arabic2CurrencyPartName = "قرشان";
                			arabic310CurrencyPartName = "قروش";
                			arabic1199CurrencyPartName = "قرشاً";
                			partPrecision = 2;
                			isCurrencyPartNameFeminine = false; 
					break;
				case TND : 	currencyID = currency;
                			currencyCode = currency.toString();
                			isCurrencyNameFeminine = false;
                			englishCurrencyName = "Tunisian Dinar";
                			englishPluralCurrencyName = "Tunisian Dinars";
                			englishCurrencyPartName = "milim";
                			englishPluralCurrencyPartName = "millimes";
                			arabic1CurrencyName = "درهم إماراتي";
                			arabic2CurrencyName = "درهمان إماراتيان";
                			arabic310CurrencyName = "دراهم إماراتية";
                			arabic1199CurrencyName = "درهماً إماراتياً";
                			arabic1CurrencyPartName = "فلس";
                			arabic2CurrencyPartName = "فلسان";
                			arabic310CurrencyPartName = "فلوس";
                			arabic1199CurrencyPartName = "فلساً";
                			partPrecision = 3;
                			isCurrencyPartNameFeminine = false;
					break;
				case XAU : 	currencyID = currency;
                			currencyCode = currency.toString();
                			isCurrencyNameFeminine = false;
                			englishCurrencyName = "Gram";
                			englishPluralCurrencyName = "Grams";
                			englishCurrencyPartName = "Milligram";
                			englishPluralCurrencyPartName = "Milligrams";
                			arabic1CurrencyName = "جرام";
                			arabic2CurrencyName = "جرامان";
                			arabic310CurrencyName = "جرامات";
                			arabic1199CurrencyName = "جراماً";
                			arabic1CurrencyPartName = "ملجرام";
                			arabic2CurrencyPartName = "ملجرامان";
                			arabic310CurrencyPartName = "ملجرامات";
                			arabic1199CurrencyPartName = "ملجراماً";
                			partPrecision = 2;
                			isCurrencyPartNameFeminine = false;
					break;
                  default  : currencyID = currency;
                            currencyCode = currency.toString();
                            isCurrencyNameFeminine = false;
                            englishCurrencyName = "Jordanian Dinar";
                            englishPluralCurrencyName = "Jordanian Dinars";
                            englishCurrencyPartName = "Fils";
                            englishPluralCurrencyPartName = "Fils";
                            arabic1CurrencyName = "دينار أردني";
                            arabic2CurrencyName = "ديناران أردنيان";
                            arabic310CurrencyName = "دنانير أردنية";
                            arabic1199CurrencyName = "دينارا أردنيا";
                            arabic1CurrencyPartName = "فلس";
                            arabic2CurrencyPartName = "فلسان";
                            arabic310CurrencyPartName = "فلس";
                            arabic1199CurrencyPartName = "فلسا";
                            partPrecision = 3;
                            isCurrencyPartNameFeminine = false;
			}
		}
	}
}
