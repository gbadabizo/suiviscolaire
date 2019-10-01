package com.all4tic.suiviscolaire.utilities;
import java.net.*;

import java.io.*;
public class SendSms
{
    public static final String apiKey ="merf2rqe6otwii5a9by6hoifv5vzsy55";
    public static final String sender = "MON ECOLIER";

    public static int solde(String apikey)

    {
        try
        {
            URL url = new URL("http://www.envoyersms.biz/api/v1/?method=credit&apikey=" + apikey);

            HttpURLConnection conn = (HttpURLConnection)url.openConnection();

            conn.setRequestMethod("GET");

            conn.connect();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            StringBuffer results = new StringBuffer();

            String solde = br.readLine();

            br.close();

            return Integer.parseInt(solde);

        }

        catch (Exception exception)

        {

            return 0;

        }

    }



    public static void send(String apikey, String number, String msg, String sender, String msg_id)
    {
        try
        {
            URL url = new URL("http://www.envoyersms.biz/api/v1/?method=send");

            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
             String postBody = "apikey=" + URLEncoder.encode(apikey, "ISO-8859-1") + "&" +

                    "number=" + URLEncoder.encode(number, "ISO-8859-1") + "&" +

                    "message=" + URLEncoder.encode(msg, "ISO-8859-1") + "&" +

                    "expediteur=" + URLEncoder.encode(sender, "ISO-8859-1") + "&" +

                    "msg_id=" + URLEncoder.encode(msg_id, "ISO-8859-1");

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

            wr.write(postBody);

            wr.flush();

            wr.close();
            conn.connect();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            StringBuffer results = new StringBuffer();
            String oneline;

            while ((oneline = br.readLine()) != null)
            {

                results.append(oneline);

            }
            br.close();

          //  System.out.println(URLDecoder.decode(results.toString(), "ISO-8859-1"));
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage() + exception.getCause());
        }

    }

/*

    public static void main(String args[])

    {
        SendSms.send(SendSms.apiKey,"22891751012","7385","TELAA","");
    }

        if (args.length == 1 && (args[0].equals("?") || args[0].equals("--help")))

        {

            System.out.println("Usage: java SendSMS [apikey] [number] [message] [exp] [msg_id]");

            System.out.println("");

            System.out.println("[apikey] = ApiKey ENVOYERSMS");

            System.out.println("[number] = Le numéro du destinataire au format international");

            System.out.println("[message] = Contenu de votre message (160 carracteres par SMS)");

            System.out.println("[exp] = Le numéro de l'expéditeur (optionnel)");

            System.out.println("[msg_id] = Identifiant du message (optionnel)");

        }

        else if (args.length == 0)

        {

            String apikey = "Votre ApiKey";

            //Recuperer le solde de son compte

            Integer solde = SendSMS.solde(apikey);

            System.out.println("Solde : " + solde);



            // Envoyer un SMS

            SendSMS.send(apikey, "33600000000", "Votre message", "envoyersms", "");

        }

        else if (args.length >= 4)

        {

            String msg_id = (args.length == 5) ? args[4] : "";

            String expediteur = (args.length >= 4) ? args[3] : "";

            SendSMS.send(args[0], args[1], args[2], expediteur, msg_id);

        }

    }*/

}