package character;

/**
 * Combines all class decorator functionality under one hood.
 */
public class ClassDecorator extends CharacterDecorator {

    Character decoratedClass;

    public ClassDecorator(Character characterRef) {
        super(characterRef);
        decoratedClass = characterRef;
    }

}
