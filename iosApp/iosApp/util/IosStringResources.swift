//
//  IosStringResources.swift
//  iosApp
//
//  Created by Darren on 2025-10-12.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import shared

func IosStringResources(id:StringResource,args:[Any]) -> String {
    return MokoStringsResources().get(id: id,args: args)
}
