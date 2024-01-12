import { Component, OnInit } from '@angular/core';
import { MeatTypeService } from "../../service/meatType.service";
import { MeatProductService } from "../../../meatProduct/service/meatProduct.service";
import { ActivatedRoute, Router } from "@angular/router";
import { MeatTypeDetails } from "../../model/meatType-details";
import {MeatTypes} from "../../model/meatTypes";
import {MeatProducts} from "../../../meatProduct/model/meatProducts";

/**
 * Preview of single character.
 */
@Component({
  selector: 'app-meatType-view',
  templateUrl: './meatType-view-component.html',
  styleUrls: ['./meatType-view-component.css']
})
export class MeatTypeViewComponent implements OnInit {

  /**
   * Single character.
   */
  meatType: MeatTypeDetails | undefined;


  meatProducts: MeatProducts |undefined;

  /**
   *
   * @param service character service
   * @param route activated route
   * @param router router
   */
  constructor(private service: MeatTypeService, private route: ActivatedRoute,
              private router: Router,private meatProductService: MeatProductService) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
    this.meatProductService.getMeatTypeMeatProducts(params['uuid'])
      .subscribe(meatProducts => this.meatProducts = meatProducts)
    });
    this.route.params.subscribe(params => {
      this.service.getMeatType(params['uuid'])
        .subscribe(meatType => this.meatType = meatType)
    });
  }

}
