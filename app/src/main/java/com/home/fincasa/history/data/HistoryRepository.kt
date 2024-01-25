package com.home.fincasa.history.data

import com.home.fincasa.R
import com.home.fincasa.models.Transaction
import java.util.Calendar
import java.util.Date

class HistoryRepository (val dataSource: HistoryDataSource) {

    private val limit : Int = 20
    var page : Int = 1
        set(value) {
            if(value > 0)
                field = value
        }

    var category : Int = 0
        set(value) {
            if(value > 0)
                field = value
        }

    /**
     * Request medias list through MediasDataSource
     * @param callback - callback para receber o resultado da requisição
     */
    //fun getMedias(callback: DataResult) {
    fun getTransactions(): List<Transaction> {
        //try {
        var cal : Calendar = Calendar.getInstance()
        cal.set(2024, 1, 1, 11, 45, 36)

        var cal2 : Calendar = Calendar.getInstance()
        cal.set(2024, 1, 2, 15, 6, 36)

        var cal3 : Calendar = Calendar.getInstance()
        cal.set(2024, 1, 4, 21, 5, 36)

        var cal4 : Calendar = Calendar.getInstance()
        cal.set(2024, 1, 5, 8, 45, 36)
        return listOf(
            Transaction(1, "6dbba0f9-5917-4fcd-b581-7e100de4ea8b", cal.time, "Ifood Trabalho", "Alimentação",  25.0f, "Bradesco", R.color.red, 1),
            Transaction(2, "6dbba0f9-5917-4fcd-b581-7e100de4ea8b", cal.time, "Ifood Trabalho", "Alimentação",  156.30f, "Bradesco", R.color.red, 3),
            Transaction(3, "f9fb10cd-0fe5-4954-a41b-c16dd54d0a04", cal.time, "Uber", "Transporte",  12.0f, "Bradesco", R.color.dark_gray, 3),
            Transaction(4, "2ca9412c-fd96-4dc5-860f-cf3620117c3a", cal.time, "Presente", "Outros",  54.0f, "Bradesco", R.color.purple_200, 3),
            Transaction(5, "1657fe25-154d-493a-8935-8f71199976c8", cal2.time, "BB", "Transferência",  25.0f, "Bradesco", R.color.blue, 2),
            Transaction(6, "1657fe25-154d-493a-8935-8f71199976c8", cal2.time, "BB", "Transferência",  25.0f, "Bradesco", R.color.blue, 3),
            Transaction(7, "f005eb44-be37-42e8-b407-60d703341849", cal2.time, "Nubank", "Fatura",  25.0f, "Bradesco", R.color.yellow, 3),
            Transaction(8, "e0557719-5054-4c98-81ad-bd1f82468e8c", cal2.time, "Ração e Banho", "Pet",  25.0f, "Bradesco", R.color.wine, 3),
            Transaction(9, "ff494119-8f13-4c1e-b7cc-72d789516968", cal2.time, "Farmácia", "Saúde",  25.0f, "Bradesco", R.color.purple_500, 3),
            Transaction(10, "fddab28a-bb31-41b5-b5fe-f5327d950fc6", cal2.time, "Unimed", "Saúde",  25.0f, "Bradesco", R.color.purple_500, 3),
            Transaction(11, "a81f6561-fd2a-4d9a-a7ad-2ceead4f935c", cal2.time, "Ifood Trabalho", "Alimentação",  25.0f, "Bradesco", R.color.red, 3),
            Transaction(12, "3401f1b9-5150-44cf-a560-85d635ced2c1", cal2.time, "Cafeteria", "Alimentação",  25.0f, "Bradesco", R.color.red, 3),
            Transaction(13, "2b915603-10c6-4f29-a952-4858d17fd3b1", cal2.time, "99", "Transporte",  7.0f, "Bradesco", R.color.dark_gray, 3),
            Transaction(14, "62db401f-805e-49cf-98de-0989525c0609", cal2.time, "Passeio no Lago", "Lazer",  46.0f, "Bradesco", R.color.teal_200, 3),
            Transaction(16, "40673bfa-006b-4d7e-9d30-0892d1edc32f", cal3.time, "Show Show", "Lazer",  125.0f, "Bradesco", R.color.teal_200, 2),
            Transaction(16, "40673bfa-006b-4d7e-9d30-0892d1edc32f", cal3.time, "Show Show", "Lazer",  125.0f, "Bradesco", R.color.teal_200, 3),
            Transaction(17, "4116ae2b-26bb-4b56-a664-41d6fd488060", cal3.time, "Teste", "Lazer",  25.0f, "Bradesco", R.color.teal_200, 3),
            Transaction(18, "d8a9a2e1-27e2-4f55-932a-aeb0d016aa92", cal4.time, "Ifood Trabalho21", "Alimentação",  25.0f, "Bradesco", R.color.red, 2),
            Transaction(19, "d8a9a2e1-27e2-4f55-932a-aeb0d016aa92", cal4.time, "Ifood Trabalho2", "Alimentação",  25.0f, "Bradesco", R.color.red, 3),
            Transaction(20, "2cd5f333-d702-4d9a-81c5-35245dc77e16", cal4.time, "Loja Viviane", "Roupas",  25.0f, "Bradesco", R.color.red, 3),
            Transaction(21, "8d84d028-2516-4487-8522-bac72fadf211", cal4.time, "Livro Data Lake", "Educação",  25.0f, "Bradesco", R.color.red, 3),
            Transaction(22, "5867d429-66d0-44a7-ad18-ad6a7adcf9c0", cal4.time, "Ifood Trabalho3", "Alimentação",  25.0f, "Bradesco", R.color.red, 3),
            Transaction(23, "f4e187eb-a22d-49e3-8f3f-991c933a537e", cal4.time, "Aluguel", "Moradia",  1980.70f, "Bradesco", R.color.soft_green, 3),
            Transaction(24, "9317c130-2b2b-455a-9381-ed08b71efea1", cal4.time, "Condomínio", "Moradia",  625.0f, "Bradesco", R.color.soft_green, 3),
            Transaction(25,"9fbde30f-aec7-48c7-960c-704942b2a8c8", cal4.time, "Ifood Trabalho5", "Alimentação",  25.0f, "Bradesco", R.color.red, 3),
            Transaction(26, "97a491f9-c0b4-47af-bde0-e1b7905aaf8d", cal4.time, "Farmácia", "Saúde",  130.0f, "Bradesco", R.color.purple_500, 4),
        )
        //dataSource.getMedias(limit, page, category, callback)
        //} catch (ex: Exception) {
        //   callback.onFailure(Result.Error(ex))
        //}
    }
}