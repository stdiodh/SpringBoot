package com.example.firstSpringBoot.human.controller

import com.example.firstSpringBoot.human.model.Human
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("/human")
class HumanControllers {
    var humans = mutableListOf (
        Human(name = "짱구", age = 5,id = 1),
        Human(name = "맹구", age = 5,id = 2),
        Human(name = "철수", age = 5,id = 3),
        Human(name = "유리", age = 5,id = 4),
    )

    @GetMapping
    fun getHumansList() : List<Human> {
        return humans
    }

    @PostMapping
    fun postHuman(@RequestBody human : Human) : Human {
        humans.add(human)
        return human
    }

    @PutMapping("/{id}")
    fun putHuman(@RequestBody human : Human, @PathVariable id : Int)
    : Human{
        for (h : Human in humans){
            if (h.id == id){
                var index = humans.indexOf(h)
                humans[index] = human
                return human
            }
        }
        humans.add(human)
        return human
    }

    @DeleteMapping("/{id}")
    fun deleteHuman(@PathVariable id: String) : Unit{
        humans.removeIf { h : Human -> h.id.toString() == id }
    }
}