package com.company;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) throws TelegramApiException {

        TelegramBotsApi telegramBotsApi1 = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi1.registerBot(new RelaxBot1());
        System.out.println(RelaxBot1.class.getName() + " running ...");


        TelegramBotsApi telegramBotsApi2 = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi2.registerBot(new RelaxBot2());
        System.out.println(RelaxBot2.class.getName() + " running ...");

        TelegramBotsApi telegramBotsApi3 = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi3.registerBot(new RelaxBot3Admin());
        System.out.println(RelaxBot3Admin.class.getName() + " running ...");
    }
}