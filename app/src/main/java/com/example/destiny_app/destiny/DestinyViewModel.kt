package com.example.destiny_app.destiny

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class DestinyViewModel: ViewModel(){

    val FIRST_OPTION = 1
    val SECOND_OPTION = 2

    companion object{
        private val SCENES = listOf<Scene>(
                Scene(
                        "Your car has blown a tire on a winding road in the middle of nowhere with no cell phone reception. You decide to hitchhike. A rusty pickup truck rumbles to a stop next to you. A man with a wide brimmed hat with soulless eyes opens the passenger door for you and asks: 'Need a ride, boy?'.",
                        "I'll hop in. Thanks for the help!",
                        "Better ask him if he's a murderer first.",
                        2,
                        1
                ),
                Scene(
                        "He nods slowly, unfazed by the question.",
                        "At least he's honest. I'll climb in.",
                        "Wait, I know how to change a tire.",
                        2,
                        3
                ),
                Scene(
                        "As you begin to drive, the stranger starts talking about his relationship with his mother. He gets angrier and angrier by the minute. He asks you to open the glovebox. Inside you find a bloody knife, two severed fingers, and a cassette tape of Elton John. He reaches for the glove box.",
                        "I love Elton John! Hand him the cassette tape.",
                        "It's him or me! You take the knife and stab him.",
                        5,
                        4
                ),
                Scene(
                        "What? Such a cop out! Did you know traffic accidents are the second leading cause of accidental death for most adult age groups?",
                        "The",
                        "End",
                        0,
                        0
                ),
                Scene(
                        "As you smash through the guardrail and careen towards the jagged rocks below you reflect on the dubious wisdom of stabbing someone while they are driving a car you are in.",
                        "The",
                        "End",
                        0,
                        0
                ),
                Scene(
                        "You bond with the murderer while crooning verses of 'Can you feel the love tonight'. He drops you off at the next town. Before you go he asks you if you know any good places to dump bodies. You reply: 'Try the pier.'",
                        "The",
                        "End",
                        0,
                        0
                )
        )
    }

    private val _currentScene = MutableLiveData<Scene>()
    val currentSceneText = Transformations.map(_currentScene){
        it.title
    }

    val firstOptionText = Transformations.map(_currentScene){
        it.option1
    }

    val secondOptionText = Transformations.map(_currentScene){
        it.option2
    }

    init{
        _currentScene.value = SCENES[0]
    }

    fun updateSceneForOption(number: Int){
        return when(number){
            1 -> _currentScene.value = SCENES[_currentScene.value!!.option1_destination]
            else -> _currentScene.value = SCENES[_currentScene.value!!.option2_destination]
        }

    }
}

data class Scene(val title: String,
                 val option1: String,
                 val option2:String,
                 val option1_destination: Int,
                 val option2_destination: Int){}
