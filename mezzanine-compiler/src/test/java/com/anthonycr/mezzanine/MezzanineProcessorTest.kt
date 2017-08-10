package com.anthonycr.mezzanine

import org.junit.Test
import testcase.InvalidFileTestCase
import testcase.ValidFileExtraSlashTestCase
import testcase.ValidFileTestCase
import javax.tools.Diagnostic

/**
 * Unit tests for [MezzanineProcessor].
 */
class MezzanineProcessorTest : AbstractAnnotationProcessorTest() {

    override fun getProcessors() = arrayListOf(MezzanineProcessor())

    @Test
    fun test_ValidFileCase_Succeeds() {
        val output = compileTestCase(ValidFileTestCase::class.java)

        assertCompilationSuccessful(output)
    }

    @Test
    fun testValidFileExtraSlashCase_Succeeds() {
        val output = compileTestCase(ValidFileExtraSlashTestCase::class.java)

        assertCompilationSuccessful(output)
    }

    @Test
    fun test_InvalidFileCase_Fails() {
        val output = compileTestCase(InvalidFileTestCase::class.java)

        assertCompilationReturned(arrayOf(Diagnostic.Kind.ERROR), longArrayOf(9), output)
    }

}
