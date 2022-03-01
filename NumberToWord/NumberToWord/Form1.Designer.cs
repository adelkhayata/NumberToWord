namespace NumberToWord
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.cboCurrency = new System.Windows.Forms.ComboBox();
            this.txtNumber = new System.Windows.Forms.TextBox();
            this.txtEnglishWord = new System.Windows.Forms.TextBox();
            this.txtArabicWord = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // cboCurrency
            // 
            this.cboCurrency.DisplayMember = "EnglishCurrencyName";
            this.cboCurrency.FormattingEnabled = true;
            this.cboCurrency.Location = new System.Drawing.Point(2, 11);
            this.cboCurrency.Name = "cboCurrency";
            this.cboCurrency.Size = new System.Drawing.Size(121, 21);
            this.cboCurrency.TabIndex = 3;
            this.cboCurrency.ValueMember = "CurrencyID";
            this.cboCurrency.DropDownClosed += new System.EventHandler(this.cboCurrency_DropDownClosed);
            // 
            // txtNumber
            // 
            this.txtNumber.Location = new System.Drawing.Point(306, 11);
            this.txtNumber.Name = "txtNumber";
            this.txtNumber.Size = new System.Drawing.Size(100, 20);
            this.txtNumber.TabIndex = 4;
            this.txtNumber.TextChanged += new System.EventHandler(this.txtNumber_TextChanged);
            // 
            // txtEnglishWord
            // 
            this.txtEnglishWord.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.txtEnglishWord.Location = new System.Drawing.Point(2, 50);
            this.txtEnglishWord.Multiline = true;
            this.txtEnglishWord.Name = "txtEnglishWord";
            this.txtEnglishWord.ReadOnly = true;
            this.txtEnglishWord.Size = new System.Drawing.Size(778, 94);
            this.txtEnglishWord.TabIndex = 5;
            // 
            // txtArabicWord
            // 
            this.txtArabicWord.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.txtArabicWord.Location = new System.Drawing.Point(2, 150);
            this.txtArabicWord.Multiline = true;
            this.txtArabicWord.Name = "txtArabicWord";
            this.txtArabicWord.ReadOnly = true;
            this.txtArabicWord.RightToLeft = System.Windows.Forms.RightToLeft.No;
            this.txtArabicWord.Size = new System.Drawing.Size(778, 94);
            this.txtArabicWord.TabIndex = 6;
            this.txtArabicWord.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(792, 305);
            this.Controls.Add(this.txtArabicWord);
            this.Controls.Add(this.txtEnglishWord);
            this.Controls.Add(this.txtNumber);
            this.Controls.Add(this.cboCurrency);
            this.Name = "Form1";
            this.Text = "C#";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ComboBox cboCurrency;
        private System.Windows.Forms.TextBox txtNumber;
        private System.Windows.Forms.TextBox txtEnglishWord;
        private System.Windows.Forms.TextBox txtArabicWord;
    }
}

