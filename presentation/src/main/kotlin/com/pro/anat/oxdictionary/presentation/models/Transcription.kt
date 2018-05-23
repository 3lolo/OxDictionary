package com.pro.anat.oxdictionary.presentation.models

class Transcription(val name: String, val transcription: String) : Field {
    override fun getType(): FieldType = FieldType.TRANSCRIPTION

}