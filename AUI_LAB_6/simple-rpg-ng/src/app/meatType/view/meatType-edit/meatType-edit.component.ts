import { Component, OnInit } from '@angular/core';
import { MeatTypeService } from '../../service/meatType.service';
import { ActivatedRoute, Router } from '@angular/router';
import { MeatTypeForm } from '../../model/meatType-form';
import { MeatProductService } from "../../../meatProduct/service/meatProduct.service";

@Component({
  selector: 'app-meatType-edit',
  templateUrl: './meatType-edit.component.html',
  styleUrls: ['./meatType-edit.component.css']
})

export class MeatTypeEditComponent implements OnInit {

  /**
   * Character's id.
   */
  uuid: string | undefined;

  /**
   * Single character.
   */
  meatType: MeatTypeForm | undefined;

  /**
   * Single character.
   */
  original: MeatTypeForm | undefined;


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

      this.meatTypeService.getMeatType(params['uuid'])
        .subscribe(meatType => {
          this.uuid = meatType.id;
          this.meatType = {
            name: meatType.name,
            popularity: meatType.popularity
          };
          this.original = {...this.meatType};
        });
    });
  }

  /**
   * Updates character.
   */
  onSubmit(): void {
    this.meatTypeService.putMeatType(this.uuid!, this.meatType!)
      .subscribe(() => this.router.navigate(['/meatTypes']));
  }

}
