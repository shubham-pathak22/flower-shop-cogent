package com.cogent.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cogent.exception.BlankOrderException;
import com.cogent.exception.InvalidOrderException;
import com.cogent.model.Flower;
import com.cogent.model.FlowerCatalogue;
import com.cogent.model.Lily;
import com.cogent.model.Order;
import com.cogent.model.Rose;
import com.cogent.model.Tulip;

/**
 * Main class simulating the Flower Shop. User can order for flowers by entering
 * the order in the format [quantity] [code], one order per line E.g 10 R12.
 */
public class FlowerShop
{

  private static List<Flower> list = new ArrayList<Flower>();

  /**
   * Adds Flower to the list of items to buy
   * 
   * @param flower
   *          Flower that is a part of the order
   */
  public static void addToList(Flower flower)
  {
    list.add(flower);
  }

  /**
   * Calulates the total cost and bundles for all items added to the list
   * 
   * @return Summary of total flower bundles and cost
   */
  public static String getReciept()
  {
    StringBuilder s = new StringBuilder();
    for (Flower f : list) {
      s.append(f.getReciept()).append("\n");
    }
    return s.toString();
  }

  public static void main(String[] args)
  {
    FlowerCatalogue f = FlowerCatalogue.getInstance();
    f.initialize();

    Scanner in;
    in = new Scanner(System.in);
    System.out.println("Please enter valid Flower Code along with quantity");
    System.out.println("Valid Flower Codes : R12, L09, T58");
    System.out.println("E.g. 10 R12");
    boolean process = true;
    while (process) {
      String inputString = in.nextLine();
      if ("BUY".equals(inputString)) {
        System.out.println(FlowerShop.getReciept());
        process = false;
      } else {

        try {
          if (inputString == "") {
            throw new BlankOrderException();
          }
          String[] input = inputString.split(" ");
          if (input.length != 2) {
            throw new InvalidOrderException();
          }
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
          System.out.println("Enter BUY to checkout or add to the order");
        } catch (IllegalArgumentException e) {
          System.out.println("Please enter valid Flower code");
        } catch (BlankOrderException | InvalidOrderException e) {
          System.out.println(e.getMessage());
        }

      }
    }
    in.close();
  }
}
