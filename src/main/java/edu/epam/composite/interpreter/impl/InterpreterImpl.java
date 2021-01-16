package edu.epam.composite.interpreter.impl;

import edu.epam.composite.interpreter.IInterpreter;
import org.nfunk.jep.JEP;

public class InterpreterImpl implements IInterpreter {
    @Override
    public String interpret(String expression) {
        double value;
        JEP jep = new JEP();
        jep.parseExpression(expression);
        value = jep.getValue();
        return String.valueOf((int) value);
    }
}
