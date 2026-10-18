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

        // 캘린더 날짜 선택 시 이벤트 처리
        calendarView?.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val monthFormatted = month + 1
            val dateStr = "${year}년 ${monthFormatted}월 ${dayOfMonth}일"
            selectedDateText?.text = "선택한 날짜: $dateStr (근무/알람 설정 가능)"
            
            Toast.makeText(this, "$dateStr 선택됨", Toast.LENGTH_SHORT).show()
        }
    }
}
