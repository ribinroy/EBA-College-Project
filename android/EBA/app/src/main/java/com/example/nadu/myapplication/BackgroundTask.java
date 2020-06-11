package com.example.nadu.myapplication;

import static com.example.nadu.myapplication.R.id.login;



        import android.app.AlertDialog;
        import android.content.Context;
        import android.content.Intent;
        import android.os.AsyncTask;
import android.os.SystemClock;
import android.view.View;
        import android.widget.TextView;
        import android.widget.Toast;
        import java.lang.String;
        import java.io.BufferedReader;
        import java.io.BufferedWriter;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.io.OutputStream;
        import java.io.OutputStreamWriter;
        import java.net.HttpURLConnection;
        import java.net.MalformedURLException;
        import java.net.URI;
        import java.net.URL;
        import java.net.URLEncoder;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;


public class BackgroundTask extends AsyncTask<String,Void,String > {
    Context ctx;
    AlertDialog alertDialog;
    String JSON_STRING = "abc";
    String uname, upass;
    TextView textview;
    String login_name, login_pass;
   public static String number,employeenumber;
    BackgroundTask(Context ctx) {
        this.ctx = ctx;
    }




    @Override
    protected void onPreExecute() {

        //super.onPreExecute();
        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Login Information");

    }
    /*public  void  intialise(String name, String pass)
    {
        uname=name;
        upass=pass;

    }*/

    @Override
    protected String doInBackground(String... params) {
        String method = params[0];
        String reg_url = "http://"+StartupScreen.ipval+"/EBA/register.php";
       // String reg_url = "http://192.168.43.124/EBA/register.php";

        String login_url = "http://"+StartupScreen.ipval+"/EBA/lo.php";
         //String login_url= "http://192.168.43.124/EBA/lo.php";


            String logged_url = "http://"+StartupScreen.ipval+"/EBA/linemanbase.php";
       //  String logged_url = "http://192.168.43.124/EBA/linemanbase.php";

        if (method.equals("register")) {
            String name = params[1];
            String address = params[2];
            String phone = params[3];
            String username = params[4];
            String consumerno = params[5];
            String password = params[6];

            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream Os = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(Os, "UTF-8"));
                String data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                        URLEncoder.encode("address", "UTF-8") + "=" + URLEncoder.encode(address, "UTF-8") + "&" +
                        URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(phone, "UTF-8") + "&" +
                        URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8") + "&" +
                        URLEncoder.encode("consumerno", "UTF-8") + "=" + URLEncoder.encode(consumerno, "UTF-8") + "&" +
                        URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                Os.close();
                InputStream inputStream = httpURLConnection.getInputStream();


                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String response = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    response += line;

                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;
            } catch (MalformedURLException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();

            }

        } else if (method.equals("login")) {
            login_name = params[1];
            login_pass = params[2];
            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data = URLEncoder.encode("login_name", "UTF-8") + "=" + URLEncoder.encode(login_name, "UTF-8") + "&" +
                        URLEncoder.encode("login_pass", "UTF-8") + "=" + URLEncoder.encode(login_pass, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String response = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    response += line;

                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if (method.equals("linemanlog")) {
           String linemanlogin_name = params[1];
           String linemanlogin_pass = params[2];
            try {
                URL url = new URL(logged_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String linemandata = URLEncoder.encode("linemanlogin_name", "UTF-8") + "=" + URLEncoder.encode(linemanlogin_name, "UTF-8") + "&" +
                        URLEncoder.encode("linemanlogin_pass", "UTF-8") + "=" + URLEncoder.encode(linemanlogin_pass, "UTF-8");
                bufferedWriter.write(linemandata);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String response = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    response += line;

                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        return null;
    }





    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        /*if (result.equals("Registration success")) {
            Toast.makeText(ctx,result, Toast.LENGTH_LONG).show();

        }*/


        //for registration of consumer
        if (result.contains("Q")) {

            //number=result.substring(result.lastIndexOf("S")+1);
            //SystemClock.sleep(2000);
           // Intent intent = new Intent(ctx,menu_page.class);
            //intent.putExtra("user",login_name);
           // ctx.startActivity(intent);
            Toast.makeText(ctx,"Register successfully", Toast.LENGTH_LONG).show();
        }


        //for registration of consumer if invalid
        if (result.contains("M")) {

            //number=result.substring(result.lastIndexOf("S")+1);
            //SystemClock.sleep(2000);
            //Intent intent = new Intent(ctx,menu_page.class);
            //intent.putExtra("user",login_name);
            //ctx.startActivity(intent);
            Toast.makeText(ctx,"Registration failed", Toast.LENGTH_LONG).show();
        }


        if (result.contains("S")) {

            number=result.substring(result.lastIndexOf("S")+1);
            //SystemClock.sleep(2000);
            Intent intent = new Intent(ctx,menu_page.class);
            //intent.putExtra("user",login_name);
            ctx.startActivity(intent);
            Toast.makeText(ctx,"Login successfully", Toast.LENGTH_LONG).show();

        }
        if (result.contains("F")) {
           // SystemClock.sleep(4000);
            Toast.makeText(ctx,"Check username/passsword", Toast.LENGTH_LONG).show();
           // alertDialog.setMessage(result);
           // alertDialog.show();
            Intent intent = new Intent(ctx,MainActivity.class);
            ctx.startActivity(intent);

        }
        if (result.contains("Z")) {
            //SystemClock.sleep(4000);
            employeenumber=result.substring(result.lastIndexOf("Z")+1);
            Intent intent = new Intent(ctx,lineman_menu.class);
            //intent.putExtra("user",login_name);
            ctx.startActivity(intent);
            Toast.makeText(ctx,"Login successful", Toast.LENGTH_LONG).show();
            //Intent intent = new Intent(ctx,menu_page.class);
            //intent.putExtra("user",login_name);
           // ctx.startActivity(intent);

        }
        if (result.contains("D")) {
            //SystemClock.sleep(3000);
            // alertDialog.setMessage(result);
            // alertDialog.show();
            Toast.makeText(ctx,"Check emplyeenumber/passsword", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(ctx,Main2Activity.class);
          ctx.startActivity(intent);

        }


        // Toast.makeText(ctx,"successfully registered", Toast.LENGTH_LONG).show();
        // Intent intent=new Intent(ctx,MainActivity.class);
        // ctx.startActivity(intent);

        // if(s.equals("1"))
        // {
        //    s="data saved";
        // }

       /* if(result.contains("1"))
        {
            alertDialog.setMessage("Login Successfully");
            alertDialog.show();
            Intent intent = new Intent(ctx, logged.class);
            intent.putExtra("user",login_name);
            ctx.startActivity(intent);

        }
        else if(result.contains("F"))
        {
            alertDialog.setMessage(result);
            alertDialog.show();
        }*/


    }
}


