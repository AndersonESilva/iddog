package br.com.anderson.iddog.util

import android.util.Patterns

/**
 * Created by anderson on 25/06/2020.
 */

fun String.validateEmailFormat(): Boolean =
    Patterns.EMAIL_ADDRESS.matcher(this).matches()