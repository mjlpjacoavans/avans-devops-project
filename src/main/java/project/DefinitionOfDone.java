package main.java.project;

public class DefinitionOfDone {
    BacklogItem backlogItem;
    String definition;
    boolean defitionMet;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DefinitionOfDone{");
        sb.append("definition='").append(definition).append('\'');
        sb.append(", defitionMet=").append(defitionMet);
        sb.append('}');
        return sb.toString();
    }

    public DefinitionOfDone(BacklogItem backlogItem, String definition){
        this.backlogItem = backlogItem;
        this.definition = definition;
        this.defitionMet = false;

        this.backlogItem.addDefinitionOfDone(this);
    }

    public void defintionMet(){
        this.defitionMet = true;
    }

    public boolean isTheDefinitionMet(){
        return this.defitionMet;
    }
}
