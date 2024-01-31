package com.yerlen.command.value;

import com.yerlen.entity.Value;
import com.yerlen.factory.ProductFactory;
import com.yerlen.factory.ValueFactory;
import com.yerlen.repository.EntityRepository;
import com.yerlen.util.Command;


public class CreateValueCommand implements Command {
    private final String valueName;

    public CreateValueCommand(String valueName){
        this.valueName = valueName;
    }

    @Override
    public void execute() {
        Value value = ValueFactory.createValue(valueName);
        new EntityRepository().saveEntity(value);
        System.out.println("Success, new product " + valueName + " was created");
    }
}
