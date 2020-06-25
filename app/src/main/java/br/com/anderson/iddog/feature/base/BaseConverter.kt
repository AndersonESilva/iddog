package br.com.anderson.iddog.feature.base

/**
 * Created by anderson on 24/06/2020.
 */
interface BaseConverter<INPUT, RETURN> {

    fun convert(input: INPUT): RETURN

}