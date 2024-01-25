package com.home.fincasa.expense

import com.home.fincasa.R
import com.home.fincasa.models.Expense
import com.home.fincasa.models.MonthOverview
import com.home.fincasa.models.Transaction
import java.util.Calendar

class MonthOverviewRepository (val dataSource: MonthOverviewDataSource) {

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
    fun getOverView(): MonthOverview {
        return MonthOverview(5300.05f, Calendar.getInstance().time, 6000.00f,  399.95f, 300.0f )
    }

    fun getFixedExpenses(): List<Expense> {
        //try {
        var cal : Calendar = Calendar.getInstance()
        cal.set(2024, 1, 1, 11, 45, 36)

        return listOf(
            Expense("6dbba0f9-5917-4fcd-b581-7e100de4ea8b", "Aluguel", cal.time, false,  null, "Casa", 0.0f,
                1971.70f, null, R.color.wine, 1),
            Expense("f9fb10cd-0fe5-4954-a41b-c16dd54d0a04", "Condomínio", cal.time, true,  null, "Casa", 796.99f,
                796.99f, null, R.color.wine, 1),
            Expense("2ca9412c-fd96-4dc5-860f-cf3620117c3a", "Psicam", cal.time, false,  null, "Saúde", 0.0f,
                500.00f, null, R.color.blue, 1),
            Expense("1657fe25-154d-493a-8935-8f71199976c8", "Academia", cal.time, true,  null, "Casa", 105.0f,
                105.00f, null, R.color.blue, 1),
            Expense("f005eb44-be37-42e8-b407-60d703341849", "Pós", cal.time, true,  null, "Educação", 130.0f,
                130.00f, null, R.color.red, 1),
            Expense("e0557719-5054-4c98-81ad-bd1f82468e8c", "Netflix", cal.time, false,  null, "Lazer", 0.0f,
                1971.70f, null, R.color.green, 2),
            Expense("ff494119-8f13-4c1e-b7cc-72d789516968", "Tim", cal.time, true,  null, "Casa", 71.99f,
                71.99f, null, R.color.wine, 2),
            Expense("fddab28a-bb31-41b5-b5fe-f5327d950fc6", "Claro", cal.time, false,  null, "Casa", 0.0f,
                100.70f, null, R.color.red, 2),
        )
        //dataSource.getMedias(limit, page, category, callback)
        //} catch (ex: Exception) {
        //   callback.onFailure(Result.Error(ex))
        //}
    }

    fun getExtraExpenses(): List<Expense> {
        //try {
        var cal : Calendar = Calendar.getInstance()
        cal.set(2024, 1, 1, 11, 45, 36)

        return listOf(
            Expense("6dbba0f9-5917-4fcd-b581-7e100de4ea8b", "Celular", cal.time, false,  null, "Compras", 0.0f,
                389.50f, null, R.color.black, 1),
            Expense("f9fb10cd-0fe5-4954-a41b-c16dd54d0a04", "Uber", cal.time, true,  null, "Transporte", 81.55f,
                81.55f, null, R.color.dark_gray, 1),
            Expense("2ca9412c-fd96-4dc5-860f-cf3620117c3a", "Açougue", cal.time, false,  null, "Alimentação", 190.80f,
                190.80f, null, R.color.yellow, 1),
            Expense("1657fe25-154d-493a-8935-8f71199976c8", "Petshop", cal.time, true,  null, "Ração e Tosa", 95.0f,
                95.00f, null, R.color.blue, 1),
            Expense("f005eb44-be37-42e8-b407-60d703341849", "Combustível", cal.time, true,  null, "Transporte", 130.0f,
                130.00f, null, R.color.dark_gray, 1),
            Expense("e0557719-5054-4c98-81ad-bd1f82468e8c", "Farmácia", cal.time, false,  null, "Saúde", 382.0f,
                382.00f, null, R.color.blue, 2),
            Expense("ff494119-8f13-4c1e-b7cc-72d789516968", "Ifood", cal.time, true,  null, "Lazer Alimentação", 66.99f,
                66.99f, null, R.color.red, 2),
        )
        //dataSource.getMedias(limit, page, category, callback)
        //} catch (ex: Exception) {
        //   callback.onFailure(Result.Error(ex))
        //}
    }
}