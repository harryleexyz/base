package com.harrylee.base.aop.pattern;

/**
 * @author harrylee
 */
public class Agent implements Person {
    private Actor actor;
    private String before;
    private String after;

    public Agent(Actor actor, String before, String after) {
        this.actor = actor;
        this.before = before;
        this.after = after;
    }

    @Override
    public void speak() {
        //before speak
        System.out.println("Before actor speak, Agent say: " + before);
        //real speak
        this.actor.speak();
        //after speak
        System.out.println("After actor speak, Agent say: " + after);
    }

    // public static void main(String[] args) {
    //     Actor actor = new Actor("I am a famous actor!");
    //     Agent agent = new Agent(actor, "Hello I am an agent.", "That's all!");
    //     agent.speak();
    // }
}
