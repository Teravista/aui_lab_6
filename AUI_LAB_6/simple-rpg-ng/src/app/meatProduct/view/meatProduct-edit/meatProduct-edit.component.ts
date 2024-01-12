import { Component, OnInit } from '@angular/core';
import { MeatProductService } from '../../service/meatProduct.service';
import { ActivatedRoute, Router } from '@angular/router';
import { MeatProductForm } from '../../model/meatProduct-form';
import { MeatTypeService } from "../../../meatType/service/meatType.service";
import { MeatTypes } from "../../../meatType/model/meatTypes";

@Component({
  selector: 'app-meatProduct-edit',
  templateUrl: './meatProduct-edit.component.html',
  styleUrls: ['./meatProduct-edit.component.css']
})

export class MeatProductEditComponent implements OnInit {

  /**
   * Character's id.
   */
  uuid: string | undefined;

  /**
   * Single character.
   */
  meatProduct: MeatProductForm | undefined;

  /**
   * Single character.
   */
  original: MeatProductForm | undefined;

  /**
   * Available professions.
   */
  meatTypes: MeatTypes | undefined;

  /**
   * @param meatProductService meatProduct service
   * @param meatTypeService meatType service
   * @param route activated route
   * @param router router
   */
  constructor(
    private meatProductService: MeatProductService,
    private meatTypeService: MeatTypeService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.meatTypeService.getMeatTypes()
        .subscribe(meatTypes => this.meatTypes = meatTypes);

      this.meatProductService.getMeatProduct(params['uuid'])
        .subscribe(meatProduct => {
          this.uuid = meatProduct.id;
          this.meatProduct = {
            name: meatProduct.name,
            intensity: meatProduct.intensity,
            meatType: meatProduct.meatType.id
          };
          this.original = {...this.meatProduct};
        });
    });
  }

  /**
   * Updates character.
   */
  onSubmit(): void {
    this.meatProductService.putMeatProduct(this.uuid!, this.meatProduct!)
      .subscribe(() => this.router.navigate(['/meatProducts']));
  }

}
