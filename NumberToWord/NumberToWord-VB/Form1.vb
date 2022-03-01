Public Class Form1
    Dim currencies As New List(Of CurrencyInfo)()
    Private Sub Form1_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        currencies.Add(New CurrencyInfo(CurrencyInfo.Currencies.Syria))
        currencies.Add(New CurrencyInfo(CurrencyInfo.Currencies.UAE))
        currencies.Add(New CurrencyInfo(CurrencyInfo.Currencies.SaudiArabia))
        currencies.Add(New CurrencyInfo(CurrencyInfo.Currencies.Tunisia))
        currencies.Add(New CurrencyInfo(CurrencyInfo.Currencies.Gold))

        cboCurrency.DataSource = currencies

        cboCurrency_DropDownClosed(Nothing, Nothing)
    End Sub

    Private Sub cboCurrency_DropDownClosed(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles cboCurrency.DropDownClosed
        txtNumber_TextChanged(Nothing, Nothing)

    End Sub

    Private Sub txtNumber_TextChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles txtNumber.TextChanged
        Try
            Dim toWord As New ToWord(Convert.ToDecimal(txtNumber.Text), currencies(Convert.ToInt32(cboCurrency.SelectedValue)))
            txtEnglishWord.Text = toWord.ConvertToEnglish()
            txtArabicWord.Text = toWord.ConvertToArabic()
        Catch ex As Exception
            txtEnglishWord.Text = [String].Empty
            txtArabicWord.Text = [String].Empty
        End Try
    End Sub
End Class
