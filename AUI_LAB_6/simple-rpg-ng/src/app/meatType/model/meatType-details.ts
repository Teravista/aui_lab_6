import { MeatType } from "../../meatType/model/meatType";

/**
 * Represents single character in list.
 */
export interface MeatTypeDetails {

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
  popularity: number;



}
