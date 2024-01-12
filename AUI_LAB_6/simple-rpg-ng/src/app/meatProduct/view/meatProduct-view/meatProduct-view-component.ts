import { Component, OnInit } from '@angular/core';
import { MeatProductService } from "../../service/meatProduct.service";
import { ActivatedRoute, Router } from "@angular/router";
import { MeatProductDetails } from "../../model/meatProduct-details";

/**
 * Preview of single character.
 */
@Component({
  selector: 'app-meatProduct-view',
  templateUrl: './meatProduct-view-component.html',
  styleUrls: ['./meatProduct-view-component.css']
})
export class MeatProductViewComponent implements OnInit {

  /**
   * Single character.
   */
  meatProduct: MeatProductDetails | undefined;

  /**
   *
   * @param service character service
   * @param route activated route
   * @param router router
   */
  constructor(private service: MeatProductService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getMeatProduct(params['uuid'])
        .subscribe(meatProduct => this.meatProduct = meatProduct)
    });
  }

}
