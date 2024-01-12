import { Component, OnInit } from '@angular/core';
import { MeatTypeService } from '../../service/meatType.service';
import { ActivatedRoute, Router } from '@angular/router';
import { MeatTypeForm } from '../../model/meatType-form';
import { MeatProductService } from "../../../meatProduct/service/meatProduct.service";

@Component({
  selector: 'app-meatType-add',
  templateUrl: './meatType-add.component.html',
  styleUrls: ['./meatType-add.component.css']
})

export class MeatTypeAddComponent implements OnInit {

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


          this.meatType = {
            name: "nazwa",
            popularity: 100
          };

    });
  }

  /**
   * Updates character.
   */
  onSubmit(): void {
    this.meatTypeService.putMeatTypeAlone( this.meatType!)
      .subscribe(() => this.router.navigate(['/meatTypes']));
  }

}
