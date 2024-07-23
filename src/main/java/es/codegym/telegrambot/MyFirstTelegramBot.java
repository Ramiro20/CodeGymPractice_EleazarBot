package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Objects;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "CodeGymPractice_EleazarBot_bot";
    public static final String TOKEN = "7293780837:AAGcNJiFwJVmibfqR23G-68Smjb5NRkkjtI";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        Message mensaje = update.getMessage();
        User usuario = mensaje.getFrom();
        // TODO: escribiremos la funcionalidad principal del bot aquí
        // si me escriben hola contestar  un saludo
        if (getMessageText().equals("/start")){
            sendTextMessageAsync("Hola _futuro_ *programador*!");}
        if (getMessageText().contains("hola")){
            sendTextMessageAsync("Hola ,Cual es tu nombre?");}
        if (getMessageText().contains("me llamo")){
            if(Objects.isNull(usuario.getUserName()))
            {
                sendTextMessageAsync("Mucho gusto");
                sendTextMessageAsync("Yo soy "+getBotUsername()+" pero me puedes decir el señor *Gato*");
                sendTextMessageAsync("Bienvenido: "+usuario.getFirstName());
            }else{
                sendTextMessageAsync("Mucho gusto");
                sendTextMessageAsync("Yo soy "+getBotUsername()+" pero me puedes decir el señor *Gato*");
                sendTextMessageAsync("Bienvenido: "+usuario.getFirstName()+" Usuario: "+usuario.getUserName());
            }}
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}