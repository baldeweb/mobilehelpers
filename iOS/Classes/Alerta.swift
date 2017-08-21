//
//  AlertaMsg.swift
//  tstps1_tudo
//
//  Created by balde on 01/06/17.
//  Copyright © 2017 balde. All rights reserved.
//

import UIKit

class Alerta : UIView {
    func alertaDialog(pTitulo: String, pMensagem: String, pCorpoMsg : String, eu : UIViewController) {
        let alerta : UIAlertController = UIAlertController.init(title: pTitulo, message: pMensagem, preferredStyle: .alert)
        alerta.message = pCorpoMsg
        alerta.addAction(UIAlertAction(title: "OK", style: UIAlertActionStyle.default, handler: nil))
        alerta.addAction(UIAlertAction(title: "CANCELAR", style: UIAlertActionStyle.cancel, handler: nil))
        eu.present(alerta, animated: true, completion: nil)
    }
    
    func alertaSheet(pTitulo: String, pMensagem: String, pCorpoMsg : String, eu : UIViewController) {
        let alerta : UIAlertController = UIAlertController.init(title: pTitulo, message: pMensagem, preferredStyle: .actionSheet)
        alerta.message = pCorpoMsg
        alerta.addAction(UIAlertAction(title: "OK", style: UIAlertActionStyle.default, handler: nil))
        alerta.addAction(UIAlertAction(title: "CANCELAR", style: UIAlertActionStyle.cancel, handler: nil))
        eu.present(alerta, animated: true, completion: nil)
    }
}

