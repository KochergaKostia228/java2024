package org.itstep.service.publication;

import org.itstep.model.PublicationInterface;

public class SearchByTitle implements SearchInterface {

    @Override
    public PublicationInterface[] search(PublicationInterface[] items, String title) {
        int count = 0;

        for(int i = 0; i < items.length; i++){
            if(title == items[i].getTitle()){
                count++;
            }
        }

        PublicationInterface[] searchArr = new PublicationInterface[count];
        if(count == 0){
            return null;
        }
        else{
            count = 0;
            System.out.println("Search by title: ");
            for (int i = 0; i < items.length; i++){
                if(title == items[i].getTitle()){
                    items[i].print();
                    searchArr[count] = items[i];
                    count++;
                }
            }
            return searchArr;
        }
    }
}
