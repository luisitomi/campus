import { BaseModel } from './../shared/module/base.model';

export class MultitableListAllModel extends BaseModel{
  itemId: number;
  description: string;
  second: string;
}

export class MultitableModel{
  itemId: number;
  description: string;
}

export class MultitableItemsModel{
  _tableId:number;
  _description:string;
}