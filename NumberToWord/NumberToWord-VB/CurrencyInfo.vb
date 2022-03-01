Public Class CurrencyInfo
    Public Enum Currencies
        Syria = 0
        UAE
        SaudiArabia
        Tunisia
        Gold
    End Enum

#Region "Constructors"

    Public Sub New(ByVal currency As Currencies)
        Select Case currency
            Case Currencies.Syria
                CurrencyID = 0
                CurrencyCode = "SYP"
                IsCurrencyNameFeminine = True
                EnglishCurrencyName = "Syrian Pound"
                EnglishPluralCurrencyName = "Syrian Pounds"
                EnglishCurrencyPartName = "Piaster"
                EnglishPluralCurrencyPartName = "Piasteres"
                Arabic1CurrencyName = "ليرة سورية"
                Arabic2CurrencyName = "ليرتان سوريتان"
                Arabic310CurrencyName = "ليرات سورية"
                Arabic1199CurrencyName = "ليرة سورية"
                Arabic1CurrencyPartName = "قرش"
                Arabic2CurrencyPartName = "قرشان"
                Arabic310CurrencyPartName = "قروش"
                Arabic1199CurrencyPartName = "قرشاً"
                PartPrecision = 2
                IsCurrencyPartNameFeminine = False
                Exit Select

            Case Currencies.UAE
                CurrencyID = 1
                CurrencyCode = "AED"
                IsCurrencyNameFeminine = False
                EnglishCurrencyName = "UAE Dirham"
                EnglishPluralCurrencyName = "UAE Dirhams"
                EnglishCurrencyPartName = "Fils"
                EnglishPluralCurrencyPartName = "Fils"
                Arabic1CurrencyName = "درهم إماراتي"
                Arabic2CurrencyName = "درهمان إماراتيان"
                Arabic310CurrencyName = "دراهم إماراتية"
                Arabic1199CurrencyName = "درهماً إماراتياً"
                Arabic1CurrencyPartName = "فلس"
                Arabic2CurrencyPartName = "فلسان"
                Arabic310CurrencyPartName = "فلوس"
                Arabic1199CurrencyPartName = "فلساً"
                PartPrecision = 2
                IsCurrencyPartNameFeminine = False
                Exit Select

            Case Currencies.SaudiArabia
                CurrencyID = 2
                CurrencyCode = "SAR"
                IsCurrencyNameFeminine = False
                EnglishCurrencyName = "Saudi Riyal"
                EnglishPluralCurrencyName = "Saudi Riyals"
                EnglishCurrencyPartName = "Halala"
                EnglishPluralCurrencyPartName = "Halalas"
                Arabic1CurrencyName = "ريال سعودي"
                Arabic2CurrencyName = "ريالان سعوديان"
                Arabic310CurrencyName = "ريالات سعودية"
                Arabic1199CurrencyName = "ريالاً سعودياً"
                Arabic1CurrencyPartName = "هللة"
                Arabic2CurrencyPartName = "هللتان"
                Arabic310CurrencyPartName = "هللات"
                Arabic1199CurrencyPartName = "هللة"
                PartPrecision = 2
                IsCurrencyPartNameFeminine = True
                Exit Select

            Case Currencies.Tunisia
                CurrencyID = 3
                CurrencyCode = "TND"
                IsCurrencyNameFeminine = False
                EnglishCurrencyName = "Tunisian Dinar"
                EnglishPluralCurrencyName = "Tunisian Dinars"
                EnglishCurrencyPartName = "milim"
                EnglishPluralCurrencyPartName = "millimes"
                Arabic1CurrencyName = "دينار تونسي"
                Arabic2CurrencyName = "ديناران تونسيان"
                Arabic310CurrencyName = "دنانير تونسية"
                Arabic1199CurrencyName = "ديناراً تونسياً"
                Arabic1CurrencyPartName = "مليم"
                Arabic2CurrencyPartName = "مليمان"
                Arabic310CurrencyPartName = "ملاليم"
                Arabic1199CurrencyPartName = "مليماً"
                PartPrecision = 3
                IsCurrencyPartNameFeminine = False
                Exit Select

            Case Currencies.Gold
                CurrencyID = 4
                CurrencyCode = "XAU"
                IsCurrencyNameFeminine = False
                EnglishCurrencyName = "Gram"
                EnglishPluralCurrencyName = "Grams"
                EnglishCurrencyPartName = "Milligram"
                EnglishPluralCurrencyPartName = "Milligrams"
                Arabic1CurrencyName = "جرام"
                Arabic2CurrencyName = "جرامان"
                Arabic310CurrencyName = "جرامات"
                Arabic1199CurrencyName = "جراماً"
                Arabic1CurrencyPartName = "ملجرام"
                Arabic2CurrencyPartName = "ملجرامان"
                Arabic310CurrencyPartName = "ملجرامات"
                Arabic1199CurrencyPartName = "ملجراماً"
                PartPrecision = 2
                IsCurrencyPartNameFeminine = False
                Exit Select

        End Select
    End Sub

#End Region

#Region "Properties"

    ''' <summary>
    ''' Currency ID
    ''' </summary>
    Public Property CurrencyID() As Integer
        Get
            Return m_CurrencyID
        End Get
        Set(ByVal value As Integer)
            m_CurrencyID = value
        End Set
    End Property
    Private m_CurrencyID As Integer

    ''' <summary>
    ''' Standard Code
    ''' Syrian Pound: SYP
    ''' UAE Dirham: AED
    ''' </summary>
    Public Property CurrencyCode() As String
        Get
            Return m_CurrencyCode
        End Get
        Set(ByVal value As String)
            m_CurrencyCode = value
        End Set
    End Property
    Private m_CurrencyCode As String

    ''' <summary>
    ''' Is the currency name feminine ( Mua'anath مؤنث)
    ''' ليرة سورية : مؤنث = true
    ''' درهم : مذكر = false
    ''' </summary>
    Public Property IsCurrencyNameFeminine() As [Boolean]
        Get
            Return m_IsCurrencyNameFeminine
        End Get
        Set(ByVal value As [Boolean])
            m_IsCurrencyNameFeminine = value
        End Set
    End Property
    Private m_IsCurrencyNameFeminine As [Boolean]

    ''' <summary>
    ''' English Currency Name for single use
    ''' Syrian Pound
    ''' UAE Dirham
    ''' </summary>
    Public Property EnglishCurrencyName() As String
        Get
            Return m_EnglishCurrencyName
        End Get
        Set(ByVal value As String)
            m_EnglishCurrencyName = value
        End Set
    End Property
    Private m_EnglishCurrencyName As String

    ''' <summary>
    ''' English Plural Currency Name for Numbers over 1
    ''' Syrian Pounds
    ''' UAE Dirhams
    ''' </summary>
    Public Property EnglishPluralCurrencyName() As String
        Get
            Return m_EnglishPluralCurrencyName
        End Get
        Set(ByVal value As String)
            m_EnglishPluralCurrencyName = value
        End Set
    End Property
    Private m_EnglishPluralCurrencyName As String

    ''' <summary>
    ''' Arabic Currency Name for 1 unit only
    ''' ليرة سورية
    ''' درهم إماراتي
    ''' </summary>
    Public Property Arabic1CurrencyName() As String
        Get
            Return m_Arabic1CurrencyName
        End Get
        Set(ByVal value As String)
            m_Arabic1CurrencyName = value
        End Set
    End Property
    Private m_Arabic1CurrencyName As String

    ''' <summary>
    ''' Arabic Currency Name for 2 units only
    ''' ليرتان سوريتان
    ''' درهمان إماراتيان
    ''' </summary>
    Public Property Arabic2CurrencyName() As String
        Get
            Return m_Arabic2CurrencyName
        End Get
        Set(ByVal value As String)
            m_Arabic2CurrencyName = value
        End Set
    End Property
    Private m_Arabic2CurrencyName As String

    ''' <summary>
    ''' Arabic Currency Name for 3 to 10 units
    ''' خمس ليرات سورية
    ''' خمسة دراهم إماراتية
    ''' </summary>
    Public Property Arabic310CurrencyName() As String
        Get
            Return m_Arabic310CurrencyName
        End Get
        Set(ByVal value As String)
            m_Arabic310CurrencyName = value
        End Set
    End Property
    Private m_Arabic310CurrencyName As String

    ''' <summary>
    ''' Arabic Currency Name for 11 to 99 units
    ''' خمس و سبعون ليرةً سوريةً
    ''' خمسة و سبعون درهماً إماراتياً
    ''' </summary>
    Public Property Arabic1199CurrencyName() As String
        Get
            Return m_Arabic1199CurrencyName
        End Get
        Set(ByVal value As String)
            m_Arabic1199CurrencyName = value
        End Set
    End Property
    Private m_Arabic1199CurrencyName As String

    ''' <summary>
    ''' Decimal Part Precision
    ''' for Syrian Pounds: 2 ( 1 SP = 100 parts)
    ''' for Tunisian Dinars: 3 ( 1 TND = 1000 parts)
    ''' </summary>
    Public Property PartPrecision() As [Byte]
        Get
            Return m_PartPrecision
        End Get
        Set(ByVal value As [Byte])
            m_PartPrecision = value
        End Set
    End Property
    Private m_PartPrecision As [Byte]

    ''' <summary>
    ''' Is the currency part name feminine ( Mua'anath مؤنث)
    ''' هللة : مؤنث = true
    ''' قرش : مذكر = false
    ''' </summary>
    Public Property IsCurrencyPartNameFeminine() As [Boolean]
        Get
            Return m_IsCurrencyPartNameFeminine
        End Get
        Set(ByVal value As [Boolean])
            m_IsCurrencyPartNameFeminine = value
        End Set
    End Property
    Private m_IsCurrencyPartNameFeminine As [Boolean]

    ''' <summary>
    ''' English Currency Part Name for single use
    ''' Piaster
    ''' Fils
    ''' </summary>
    Public Property EnglishCurrencyPartName() As String
        Get
            Return m_EnglishCurrencyPartName
        End Get
        Set(ByVal value As String)
            m_EnglishCurrencyPartName = value
        End Set
    End Property
    Private m_EnglishCurrencyPartName As String

    ''' <summary>
    ''' English Currency Part Name for Plural
    ''' Piasters
    ''' Fils
    ''' </summary>
    Public Property EnglishPluralCurrencyPartName() As String
        Get
            Return m_EnglishPluralCurrencyPartName
        End Get
        Set(ByVal value As String)
            m_EnglishPluralCurrencyPartName = value
        End Set
    End Property
    Private m_EnglishPluralCurrencyPartName As String

    ''' <summary>
    ''' Arabic Currency Part Name for 1 unit only
    ''' قرش
    ''' هللة
    ''' </summary>
    Public Property Arabic1CurrencyPartName() As String
        Get
            Return m_Arabic1CurrencyPartName
        End Get
        Set(ByVal value As String)
            m_Arabic1CurrencyPartName = value
        End Set
    End Property
    Private m_Arabic1CurrencyPartName As String

    ''' <summary>
    ''' Arabic Currency Part Name for 2 unit only
    ''' قرشان
    ''' هللتان
    ''' </summary>
    Public Property Arabic2CurrencyPartName() As String
        Get
            Return m_Arabic2CurrencyPartName
        End Get
        Set(ByVal value As String)
            m_Arabic2CurrencyPartName = value
        End Set
    End Property
    Private m_Arabic2CurrencyPartName As String

    ''' <summary>
    ''' Arabic Currency Part Name for 3 to 10 units
    ''' قروش
    ''' هللات
    ''' </summary>
    Public Property Arabic310CurrencyPartName() As String
        Get
            Return m_Arabic310CurrencyPartName
        End Get
        Set(ByVal value As String)
            m_Arabic310CurrencyPartName = value
        End Set
    End Property
    Private m_Arabic310CurrencyPartName As String

    ''' <summary>
    ''' Arabic Currency Part Name for 11 to 99 units
    ''' قرشاً
    ''' هللةً
    ''' </summary>
    Public Property Arabic1199CurrencyPartName() As String
        Get
            Return m_Arabic1199CurrencyPartName
        End Get
        Set(ByVal value As String)
            m_Arabic1199CurrencyPartName = value
        End Set
    End Property
    Private m_Arabic1199CurrencyPartName As String
#End Region
End Class
