//
//  LandmarkTip.swift
//  iosApp
//
//  Created by Darren on 2025-10-12.
//  Copyright © 2025 orgName. All rights reserved.
//


import SwiftUI
import TipKit
import shared

struct MapTip: Tip, Identifiable {
    var id = UUID()

    var title: Text {
        Text(IosStringResources(id: SharedRes.strings().logo_land, args: []))
    }

    var image: Image? {
        Image(systemName: "map")
    }
}

struct FeedbackTip: Tip, Identifiable {
    var id = UUID()

    var title: Text {
        Text(IosStringResources(id: SharedRes.strings().logo_land, args: []))
    }

    var image: Image? {
        Image(systemName: "person.fill")
    }
}

struct BottomBarTip: Tip, Identifiable {
    var id = UUID()

    var title: Text {
        Text(IosStringResources(id: SharedRes.strings().logo_land, args: []))
    }
}

struct SwipyTip: Tip, Identifiable {
    var id = UUID()

    var title: Text {
        Text(IosStringResources(id: SharedRes.strings().logo_land, args: []))
    }
}
