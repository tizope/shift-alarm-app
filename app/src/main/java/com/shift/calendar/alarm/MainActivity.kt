package com.shift.calendar.alarm

import android.os.Bundle
import android.widget.CalendarView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calendarView = findViewById<CalendarView>(R.id.calendarView)
        val selectedDateText = findViewById<TextView>(R.id.selectedDateText)

        calendarView?.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val dateStr = "${year}년 ${month + 1}월 ${dayOfMonth}일"
            selectedDateText?.text = "선택한 날짜: $dateStr"
            Toast.makeText(this, "$dateStr 근무 일정을 확인합니다.", Toast.LENGTH_SHORT).show()
        }
    }
}
