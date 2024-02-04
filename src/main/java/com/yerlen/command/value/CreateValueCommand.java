package com.yerlen.command.value;

import com.yerlen.entity.Option;
import com.yerlen.entity.Product;
import com.yerlen.entity.Value;
import com.yerlen.factory.ValueFactory;
import com.yerlen.repository.ValueRepository;
import com.yerlen.util.Command;
import com.yerlen.view.View;


public class CreateValueCommand implements Command {
    private final String valueName;
    private final Option option;
    private final Product product;

    public CreateValueCommand(String valueName, Option option, Product product) {
        this.valueName = valueName;
        this.option = option;
        this.product = product;
    }

    @Override
    public void execute() {
        Value value = ValueFactory.createValue(valueName, option, product);
        ValueRepository.saveEntity(value);
        View.showCreateValue(valueName);
    }
}
