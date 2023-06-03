package org.example.XML;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@Getter
@Setter
public class RootXml<T> {
    private List<T> listOfElements = new ArrayList<>();

    public void addObject(T object) {
        listOfElements.add(object);
    }
}
