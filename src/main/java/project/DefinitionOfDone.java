package project;

public class DefinitionOfDone {
    BacklogItem backlogItem;
    String definition;

    //TODO: deze klasse verwijderen (vraag feedback) herschrijven naar hetzelfde als een devloper

    public DefinitionOfDone(BacklogItem backlogItem, String definition){
        this.backlogItem = backlogItem;
        this.definition = definition;

        this.backlogItem.addDefinitionOfDone(this);
    }
    //Use this setter external only

}
