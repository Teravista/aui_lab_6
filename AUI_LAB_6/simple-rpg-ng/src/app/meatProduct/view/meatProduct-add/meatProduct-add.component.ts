import { Component, OnInit } from '@angular/core';
import { MeatProductService } from '../../service/meatProduct.service';
import { ActivatedRoute, Router } from '@angular/router';
import { MeatProductForm } from '../../model/meatProduct-form';
import { MeatTypeService } from "../../../meatType/service/meatType.service";
import { MeatTypes } from "../../../meatType/model/meatTypes";

@Component({
  selector: 'app-meatProduct-add',
  templateUrl: './meatProduct-add.component.html',
  styleUrls: ['./meatProduct-add.component.css']
})

export class MeatProductAddComponent implements OnInit {

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


          this.meatProduct = {
            name: "n",
            intensity: 1,
            meatType: "string"
          };

    });
  }

  /**
   * Updates character.
   */
  onSubmit(): void {
    this.meatProductService.putMeatProductAllone(this.meatProduct!)
      .subscribe(() => this.router.navigate(['/meatProducts']));
  }

}
