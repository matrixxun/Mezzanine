package com.anthonycr.mezzanine.filter

import com.anthonycr.mezzanine.utils.MessagerUtils
import java.io.File
import javax.lang.model.element.TypeElement

/**
 * Filters out non existent files and reports an error.
 */
object NonExistentFileFilter : (Pair<TypeElement, File>) -> Boolean {

    override fun invoke(pair: Pair<TypeElement, File>): Boolean {
        return pair.second.exists().also {
            if (!it) {
                MessagerUtils.reportError(pair.first, "File does not exist")
            }
        }
    }

}