import { MeatType } from "../../meatType/model/meatType";

/**
 * Represents single character in list.
 */
export interface MeatProductDetails {

  /**
   * Unique id identifying character.
   */
  id: string;

  /**
   * Name of the character.
   */
  name: string;

  /**
   * Character's intensity.
   */
  intensity: number;

  /**
   * Character's profession.
   */
  meatType: MeatType;

}
