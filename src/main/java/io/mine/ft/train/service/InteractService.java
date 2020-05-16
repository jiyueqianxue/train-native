package io.mine.ft.train.service;

import java.util.List;

import io.mine.ft.train.entity.Accusation;
import io.mine.ft.train.entity.Interact;
import io.mine.ft.train.entity.User;

public interface InteractService {
public List<Interact> QueryAllInteract(Integer sId);
public List<Interact> QueryAllInteract(String flagAnswer,String information,String name,Integer sId);
public void deleteInteractService (Integer interactId);
public void addInteractService (Interact it);
public List<User> QueryAllTeacherService();
public Interact QueryDetailById(Integer interactId);
public void updateInteractService(Interact it);
public void AddAccusationService(Accusation acc);
}
