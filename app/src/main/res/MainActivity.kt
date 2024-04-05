import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(Result.layout.activity_main)

        val btn1 = findViewById<Button>(R.id.btn1)
        val etAge = findViewById<EditText>(R.id.etAge)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btn1.setOnClickListener {
            val birthYearText = etAge.text.toString()
            if (birthYearText.isNotEmpty()) {
                val birthYear = birthYearText.toIntOrNull()
                if (birthYear != null) {
                    val currentYear = Calendar.getInstance().get(Calendar.YEAR)
                    val userAge = currentYear - birthYear
                    tvResult.text = "You are $userAge years old."
                    compareWithHistoricalFigures(userAge, tvResult)
                } else {
                    tvResult.text = "Please enter a valid birth year."
                }
            } else {
                tvResult.text = "Please enter your birth year."
            }
        }
    }

    private fun compareWithHistoricalFigures(userAge: Int, tvResult: TextView) {
        val historicalFigures = mapOf(
            51 to "Paul Walker",
            48 to "Chadwick Boseman",
            32 to "Mac Miller",
            25 to "Cameron Boyce",
            61 to "Whitney Houston",
            66 to "Michael Jackson",
            53 to "Tupac Shakur",
            98 to "Marilyn Monroe",
            55 to "Matthew Perry",
            155 to "Mahatma Gandhi"
        )

        val matchedFigures = historicalFigures.filter { it.key == userAge }
        if (matchedFigures.isNotEmpty()) {
            val matchedNames = matchedFigures.values.joinToString(", ")
            tvResult.append("\nYou share your age with: $matchedNames")
        } else {
            tvResult.append("\nYou don't share your age with any historical figures in this list.")
        }
    }
}
