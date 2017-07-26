package com.anthonycr.mezzanine.function

import com.google.common.base.Charsets
import io.reactivex.functions.Function
import java.io.File
import java.nio.file.Files
import javax.lang.model.element.TypeElement

/**
 * A mapping function that takes a stream of
 * interfaces and files and reads in the file,
 * emitting an stream of interfaces and file
 * contents (as strings).
 *
 * @return a valid mapping function.
 */
object FileToStringContentsFunction : Function<Pair<TypeElement, File>, Pair<TypeElement, String>> {

    override fun apply(filePair: Pair<TypeElement, File>): Pair<TypeElement, String> {
        val fileAsString = String(Files.readAllBytes(filePair.second.toPath()), Charsets.UTF_8)

        return Pair(filePair.first, fileAsString)
    }

}