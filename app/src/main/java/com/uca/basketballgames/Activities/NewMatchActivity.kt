package com.uca.basketballgames.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import com.uca.basketballgames.Model.ScoreViewModel
import com.uca.basketballgames.R
import kotlinx.android.synthetic.main.activity_new_match.*

class NewMatchActivity : AppCompatActivity() {

    lateinit var scoreViewModel: ScoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_match)

        scoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)

        displayScore(
            tv_score_team_a,
            scoreViewModel.ScoreTeamA
        )

        displayScore(
            tv_score_team_b,
            scoreViewModel.ScoreTeamB
        )
    }

    fun addOneTeamA(v: View) {
        displayScore(
            tv_score_team_a,
            ++scoreViewModel.ScoreTeamA
        )
    }

    fun addOneTeamB(v: View) {
        displayScore(
            tv_score_team_b,
            ++scoreViewModel.ScoreTeamB
        )
    }

    fun addTwoTeamA(v: View) {
        scoreViewModel.ScoreTeamA += 2
        displayScore(
            tv_score_team_a,
            scoreViewModel.ScoreTeamA
        )
    }

    fun addTwoTeamB(v: View) {
        scoreViewModel.ScoreTeamB += 2
        displayScore(
            tv_score_team_b,
            scoreViewModel.ScoreTeamB
        )
    }

    fun addThreeTeamA(v: View) {
        scoreViewModel.ScoreTeamA += 3
        displayScore(
            tv_score_team_a,
            scoreViewModel.ScoreTeamA
        )
    }

    fun addThreeTeamB(v: View) {
        scoreViewModel.ScoreTeamB += 3
        displayScore(
            tv_score_team_b,
            scoreViewModel.ScoreTeamB
        )
    }

    fun resetScores(v: View) {
        scoreViewModel.ScoreTeamA = 0
        scoreViewModel.ScoreTeamB = 0

        displayScore(
            tv_score_team_a,
            scoreViewModel.ScoreTeamA
        )

        displayScore(
            tv_score_team_b,
            scoreViewModel.ScoreTeamB
        )
    }

    fun displayScore(v: TextView, score: Int) {
        v.text = score.toString()
    }
}
