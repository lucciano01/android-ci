package com.example.teste;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.Espresso.*;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class MainActivityTest {

    //comentário para verificaçao do build automatizado com Jenkins

    @Rule
    public ActivityTestRule<MainActivity> testRule = new ActivityTestRule<>(MainActivity.class);
    private String nome = "Teste";

    @Test
    public void deveriaExibirONome(){
        //inserir o nome
        onView(withId(R.id.editTextNome)).perform(typeText(nome));
        //fechar o teclado
        Espresso.closeSoftKeyboard();
        //acionar o botao
        onView(withId(R.id.buttonEnviar)).perform(click());
        //verificar se o texto esta sendo exibido
        onView(withId(R.id.textViewNomeRecebido)).check(matches(withText(nome)));

    }

    @Test
    public void deveriaExibirMensagemDeCampoObrigatorio(){
        onView(withId(R.id.buttonEnviar)).perform(click());
        onView(withId(R.id.textMensagem)).check(matches(isDisplayed()));
    }

}