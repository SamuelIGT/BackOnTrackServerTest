package br.ufc.quixada.backontrackservertest.activity;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.springframework.http.HttpEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import br.ufc.quixada.backontrackservertest.R;
import br.ufc.quixada.backontrackservertest.model.Exercise;
import br.ufc.quixada.backontrackservertest.model.Report;

public class MainActivity extends AppCompatActivity {
    final String url = "http://localhost:8080";
    ProgressBar pgbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pgbar = (ProgressBar)findViewById(R.id.pgbar);
    }

    public void getExercise(View view){
        new ExerciseRequestTask().execute();
        pgbar.setVisibility(View.VISIBLE);
    }
    public void postReport(View view){
        int time;
        int effortLevel;
        int sets;
        int repetitions;

        EditText timeT = (EditText) findViewById(R.id.textV_send_time);
        EditText effortLevelT = (EditText) findViewById(R.id.textV_send_esforco);
        EditText setsT = (EditText) findViewById(R.id.textV_send_sets);
        EditText repetitionsT = (EditText) findViewById(R.id.textV_send_repetition);

        time = Integer.parseInt(timeT.getText().toString());
        effortLevel = Integer.parseInt(effortLevelT.getText().toString());
        sets = Integer.parseInt(setsT.getText().toString());
        repetitions = Integer.parseInt(repetitionsT.getText().toString());

        new ReportPostTask(time, effortLevel, sets, repetitions).execute();
    }




    private class ExerciseRequestTask extends AsyncTask<Void, Void, Exercise> {

        @Override
        protected Exercise doInBackground(Void... params) {

            try {
                final String exerciseUrl = url + "/exercises/by/1";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Exercise exercise = restTemplate.getForObject(exerciseUrl, Exercise.class);
                String exer = restTemplate.getForObject(exerciseUrl, String.class);
                Log.e("Msg", exer);
                return exercise;
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }

            return null;
        }

        @Override
        protected void onPostExecute(Exercise exercise) {
            TextView titleText = (TextView) findViewById(R.id.textView);
            TextView descriptionText = (TextView) findViewById(R.id.textView4);
            titleText.setText(exercise.getTitle());
            descriptionText.setText(exercise.getDescription());
            pgbar.setVisibility(View.GONE);
        }

    }

    private class ReportPostTask extends AsyncTask<Void, Void, String> {
        private Report report;
        public ReportPostTask(int time, int effortLevel, int sets, int repetitions){
            report = new Report();
            report.setEffortLevel(effortLevel);
            report.setTime(time);
            report.setSets(sets);
            report.setRepetitions(repetitions);
        }

        @Override
        protected String doInBackground(Void... params) {

            try {
                final String exerciseUrl = url + "/report";
                RestTemplate restTemplate = new RestTemplate();
             //   HttpEntity<Report> request = new HttpEntity<>(report);
              //  restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                String response = restTemplate.postForObject(exerciseUrl, report, String.class);
                return response;
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }

            return null;
        }


        @Override
        protected void onPostExecute(String response) {
            TextView ok = (TextView) findViewById(R.id.textV_OK);
            ok.setVisibility(View.VISIBLE);
            ok.setText(response);
        }

    }

}
