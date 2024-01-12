import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MeatProductListComponent } from "./meatProduct/view/meatProduct-list/meatProduct-list.component";
import { MeatProductViewComponent } from "./meatProduct/view/meatProduct-view/meatProduct-view-component";
import { MeatProductEditComponent } from "./meatProduct/view/meatProduct-edit/meatProduct-edit.component";
import { MeatTypeListComponent } from "./meatType/view/meatType-list/meatType-list.component";
import {MeatTypeEditComponent} from "./meatType/view/meatType-edit/meatType-edit.component";
import {MeatTypeViewComponent} from "./meatType/view/meatType-view/meatType-view-component";
import {MeatProductAddComponent} from "./meatProduct/view/meatProduct-add/meatProduct-add.component";
import {MeatTypeAddComponent} from "./meatType/view/meatType-add/meatType-add.component";

/**
 * All available routes.
 */
const routes: Routes = [
  {
    component: MeatProductListComponent,
    path: "meatProducts"
  },
  {
    component: MeatProductViewComponent,
    path: "meatProducts/:uuid"
  }
  ,
  {
    component: MeatProductEditComponent,
    path: "meatProducts/:uuid/edit"
  }
  ,
  {
    component: MeatTypeListComponent,
    path: "meatTypes"
  },
  {
    component: MeatTypeEditComponent,
    path: "meatTypes/:uuid/edit"
  },
  {
    component: MeatTypeViewComponent,
    path: "meatTypes/:uuid"
  },
  {
    component: MeatProductAddComponent,
    path: "meatProductsADD"
  }
  ,
  {
    component: MeatTypeAddComponent,
    path: "meatTypeADD"
  }
];

/**
 * Global routing module.
 */
@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {

}
