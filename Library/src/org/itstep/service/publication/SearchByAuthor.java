package org.itstep.service.publication;

import org.itstep.model.Book;
import org.itstep.model.PublicationInterface;

public class SearchByAuthor implements SearchInterface {

    @Override
    public PublicationInterface[] search(PublicationInterface[] items, String author) {
        int count = 0;

        for(int i = 0; i < items.length; i++){
            if(items[i] instanceof Book){
                if(author == ((Book) items[i]).getAuthor()){
                    count++;
                }
            }
        }

        PublicationInterface[] searchArr = new PublicationInterface[count];
        if(count == 0){
            return null;
        }
        else{
            count = 0;
            System.out.println("Search by author: ");
            for (int i = 0; i < items.length; i++){
                if(items[i] instanceof Book){
                    if(author == ((Book) items[i]).getAuthor()){
                        items[i].print();
                        searchArr[count] = items[i];
                        count++;
                    }
                }
            }
            return searchArr;
        }
    }
}
