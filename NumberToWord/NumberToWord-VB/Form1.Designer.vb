<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form1
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.txtArabicWord = New System.Windows.Forms.TextBox()
        Me.txtEnglishWord = New System.Windows.Forms.TextBox()
        Me.txtNumber = New System.Windows.Forms.TextBox()
        Me.cboCurrency = New System.Windows.Forms.ComboBox()
        Me.SuspendLayout()
        '
        'txtArabicWord
        '
        Me.txtArabicWord.Anchor = CType(((System.Windows.Forms.AnchorStyles.Top Or System.Windows.Forms.AnchorStyles.Left) _
                    Or System.Windows.Forms.AnchorStyles.Right), System.Windows.Forms.AnchorStyles)
        Me.txtArabicWord.Location = New System.Drawing.Point(12, 146)
        Me.txtArabicWord.Multiline = True
        Me.txtArabicWord.Name = "txtArabicWord"
        Me.txtArabicWord.ReadOnly = True
        Me.txtArabicWord.RightToLeft = System.Windows.Forms.RightToLeft.No
        Me.txtArabicWord.Size = New System.Drawing.Size(692, 94)
        Me.txtArabicWord.TabIndex = 10
        Me.txtArabicWord.TextAlign = System.Windows.Forms.HorizontalAlignment.Right
        '
        'txtEnglishWord
        '
        Me.txtEnglishWord.Anchor = CType(((System.Windows.Forms.AnchorStyles.Top Or System.Windows.Forms.AnchorStyles.Left) _
                    Or System.Windows.Forms.AnchorStyles.Right), System.Windows.Forms.AnchorStyles)
        Me.txtEnglishWord.Location = New System.Drawing.Point(12, 46)
        Me.txtEnglishWord.Multiline = True
        Me.txtEnglishWord.Name = "txtEnglishWord"
        Me.txtEnglishWord.ReadOnly = True
        Me.txtEnglishWord.Size = New System.Drawing.Size(692, 94)
        Me.txtEnglishWord.TabIndex = 9
        '
        'txtNumber
        '
        Me.txtNumber.Location = New System.Drawing.Point(316, 7)
        Me.txtNumber.Name = "txtNumber"
        Me.txtNumber.Size = New System.Drawing.Size(100, 20)
        Me.txtNumber.TabIndex = 8
        '
        'cboCurrency
        '
        Me.cboCurrency.DisplayMember = "EnglishCurrencyName"
        Me.cboCurrency.FormattingEnabled = True
        Me.cboCurrency.Location = New System.Drawing.Point(12, 7)
        Me.cboCurrency.Name = "cboCurrency"
        Me.cboCurrency.Size = New System.Drawing.Size(121, 21)
        Me.cboCurrency.TabIndex = 7
        Me.cboCurrency.ValueMember = "CurrencyID"
        '
        'Form1
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(716, 249)
        Me.Controls.Add(Me.txtArabicWord)
        Me.Controls.Add(Me.txtEnglishWord)
        Me.Controls.Add(Me.txtNumber)
        Me.Controls.Add(Me.cboCurrency)
        Me.Name = "Form1"
        Me.Text = "VB"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Private WithEvents txtArabicWord As System.Windows.Forms.TextBox
    Private WithEvents txtEnglishWord As System.Windows.Forms.TextBox
    Private WithEvents txtNumber As System.Windows.Forms.TextBox
    Private WithEvents cboCurrency As System.Windows.Forms.ComboBox

End Class
