package com.cogent.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cogent.model.Flower;
import com.cogent.model.FlowerCatalogue;
import com.cogent.model.Lily;
import com.cogent.model.Order;
import com.cogent.model.Rose;
import com.cogent.model.Tulip;

public class FlowerShop
{

  private static List<Flower> list = new ArrayList<Flower>();

  public static void addToList(Flower flower)
  {
    list.add(flower);
  }

  public static void getReciept()
  {
    for (Flower f : list) {
      System.out.println(f.getReciept());
    }
  }

  public static void main(String[] args)
  {
    Scanner in;
    in = new Scanner(System.in);

    FlowerCatalogue f = FlowerCatalogue.getInstance();
    f.initialize();

    boolean process = true;
    while (process) {
      String inputString = in.nextLine();
      if ("BUY".equals(inputString)) {
        FlowerShop.getReciept();
        process = false;
      } else {

        String[] input = inputString.split(" ");
        FlowerType type = FlowerType.valueOf(input[1]);
        switch (type) {
          case R12:
            FlowerShop.addToList(new Rose(type.toString(), new Order(Integer.parseInt(input[0]))));
            break;
          case L09:
            FlowerShop.addToList(new Lily(type.toString(), new Order(Integer.parseInt(input[0]))));
             break;
          case T58:
            FlowerShop.addToList(new Tulip(type.toString(), new Order(Integer.parseInt(input[0]))));
             break;
          default:
            break;
        }
      }
    }
    in.close();
  }
}
