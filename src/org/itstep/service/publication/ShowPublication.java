package org.itstep.service.publication;

import org.itstep.model.PublicationInterface;

public class ShowPublication implements ShowPublicationInterface{

    @Override
    public void showItems(PublicationInterface[] items) {
        for(int i = 0; i < items.length; i++){
            items[i].print();
        }
    }
}
