package com.company;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class RelaxBot3Admin extends TelegramLongPollingBot {

    public RelaxBot3Admin() {
        super("7996754626:AAGJ4JRkjajdbCHwSdrQ9CtKGG504C-zSwg");
    }

    @Override
    public String getBotUsername() {
        return "https://t.me/OrhideyaHotelSpaAdminbot";
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage()) {

            Message message = update.getMessage();
            Long chatId = message.getChatId();

            if (message.hasText()) {

                String text = message.getText();

                switch (text) {
                    case Components.START -> sendMessage(Components.OVERVIEW, chatId);
                    case Components.PRICES -> sendPrices(chatId);
                    default -> sendMessage(Components.ERROR, chatId);
                }
            }

        }
    }

    private void sendPrices(Long chatId) {

        sendMessage(Components.PRICE_3, chatId);
        sendMessage(Components.WILL_CONTACT + Components.PHONE_2, chatId);
    }

    private void sendMessage(String text, Long chatId) {

        SendMessage sendMessage = SendMessage.builder()
                .text(text)
                .chatId(chatId)
                .build();
        sendMessage.setReplyMarkup(getMenu());

        try {
            execute(sendMessage);

        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private ReplyKeyboardMarkup getMenu() {

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        KeyboardRow keyboardButtonRow = new KeyboardRow();
        List<KeyboardRow> keyboardButtonList = new ArrayList<>();

        KeyboardButton prices = new KeyboardButton(Components.PRICES);

        keyboardButtonRow.add(prices);

        keyboardButtonList.add(keyboardButtonRow);
        replyKeyboardMarkup.setKeyboard(keyboardButtonList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setIsPersistent(true);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        return replyKeyboardMarkup;
    }
}
