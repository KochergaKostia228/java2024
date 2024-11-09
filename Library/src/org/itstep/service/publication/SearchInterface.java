package org.itstep.service.publication;

import org.itstep.model.PublicationInterface;

public interface SearchInterface {
    PublicationInterface[] search(PublicationInterface[] items, String text);
}
