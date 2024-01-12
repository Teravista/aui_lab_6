import { Component, OnInit } from '@angular/core';
import { MeatProductService } from "../../service/meatProduct.service";
import { MeatProducts } from "../../model/meatProducts";
import { MeatProduct } from "../../model/meatProduct";

@Component({
  selector: 'app-meatProduct-list',
  templateUrl: './meatProduct-list.component.html',
  styleUrls: ['./meatProduct-list.component.css']
})
export class MeatProductListComponent implements OnInit{

  /**
   * @param service characters service
   */
  constructor(private service: MeatProductService) {
  }

  /**
   * Available characters.
   */
  meatProducts: MeatProducts | undefined;

  ngOnInit(): void {
    this.service.getMeatProducts().subscribe(meatProducts => this.meatProducts = meatProducts);
  }

  /**
   * Deletes selected character.
   *
   * @param user character to be removed
   */
  onDelete(meatProduct: MeatProduct): void {
    this.service.deleteMeatProduct(meatProduct.id).subscribe(() => this.ngOnInit());
  }

}
